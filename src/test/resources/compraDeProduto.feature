#language:pt
#Author: Vinicius Marra Santos

@CadCli
Funcionalidade: Compra de produtos

  @ComprarProdutoC @Chrome
  Cenario: compra um produto no site 
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta e clico em register
    E na tela inicial no campo busca digite "Dress" e clique em pesquisar
    E Adiciono um produto ao meu carrinho 
    E sigo para o pagamento
    E na tela de Summary eu clico em proceed to checkout
    E na tela de adress eu clico em proceed to checkout
    E na tela de shipping eu aceito os termos e clico em proceed to checkout
    E na tela de opção de pagamento eu clico em pay by bank wire
    E na tela de Payment eu clico em i confirm my order
    Entao apos finalizar o pagamento deve apresentar a mensagem "Your order on My Store is complete."
  
  
    @ComprarDoisProdutosF @Firefox
  Cenario: compra dois produtos no site 
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta e clico em register
    E na tela inicial no campo busca digite "Dress" e clique em pesquisar
    E Adiciono um produto ao meu carrinho 
    E volto para adicionar mais intens
    E na tela inicial no campo busca digite "Dress" e clique em pesquisar
    E Adiciono um outro produto ao meu carrinho
    E sigo para o pagamento
    E na tela de Summary eu clico em proceed to checkout
    E na tela de adress eu clico em proceed to checkout
    E na tela de shipping eu aceito os termos e clico em proceed to checkout
    E na tela de opção de pagamento eu clico em pay by bank wire
    E na tela de Payment eu clico em i confirm my order
    Entao apos finalizar o pagamento deve apresentar a mensagem "Your order on My Store is complete."
      