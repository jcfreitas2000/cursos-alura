package br.com.gbd.alura.conf;

import br.com.gbd.alura.controllers.HomeController;
import br.com.gbd.alura.daos.ProdutoDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
    Autor(es): José Carlos de Freitas
    Data: 05/03/2017 às 10:33:53
    Arquivo: AppWebConfiguration
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class})
class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolve() {
        InternalResourceViewResolver resolve = new InternalResourceViewResolver();
        resolve.setPrefix("/WEB-INF/jsp/");
        resolve.setSuffix(".jsp");
        return resolve;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("/WEB-INF/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);

        return messageSource;
    }

    @Bean
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateFormatterRegistrar registra = new DateFormatterRegistrar();
        registra.setFormatter(new DateFormatter("dd/MM/yyyy"));
        registra.registerFormatters(conversionService);

        return conversionService;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
