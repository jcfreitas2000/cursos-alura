<?php 
require_once("estrutura/cabecalho.php");
require_once("produtoDAO.php");
require_once('logica-usuario.php');

verificaUsuario();

$nome = $_POST["nome"];
$valor = $_POST["preco"];
$decricao = $_POST["descricao"];
$categoria_id = $_POST["categoria_id"];
if(array_key_exists("usado", $_POST)){
	$usado = "true";
} else {
	$usado = "false";
}

if(insereProduto($conexao, $nome, $valor, $decricao, $categoria_id, $usado)){
	?>
	<p class="alert-success">O produto <?=$nome?> (R$ <?=$valor?>) foi adicionado com sucesso</p>
	<?php
} else {
	$msg = mysqli_error($conexao);
	?>
	<p class="alert-danger">O produto <?=$nome?> (R$ <?=$valor?>) não adicionado: <?=$msg?></p>
	<?php
}
?>
<?php require_once('estrutura/rodape.php');?>