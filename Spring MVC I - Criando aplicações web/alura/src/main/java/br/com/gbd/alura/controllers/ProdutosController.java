package br.com.gbd.alura.controllers;

import br.com.gbd.alura.daos.ProdutoDAO;
import br.com.gbd.alura.infra.FileSaver;
import br.com.gbd.alura.models.Produto;
import br.com.gbd.alura.models.TipoPreco;
import br.com.gbd.alura.validation.ProdutoValidation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
    Autor(es): José Carlos de Freitas
    Data: 05/03/2017 às 13:39:58
    Arquivo: ProdutosController
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value="produtoHome",allEntries=true)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return form(produto);
        }

        fileSaver.grava("arquivos-sumario", sumario);

        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("msg", "Produto cadastrado com sucesso!");

        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = this.produtoDAO.listar();

        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }

    @RequestMapping("{id}")
    public ModelAndView detalheProduto(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
        
        modelAndView.addObject("produto", produtoDAO.find(id));
        
        return modelAndView;
    }
} 
