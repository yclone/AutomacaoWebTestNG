#language:pt
#Author: Vinicius Marra Santos

@CadCli
Funcionalidade: Cadastrar um cliente

  @CadastroFelizC @Chrome
  Cenario: criar o cadastro de um novo cliente no sistema com dados ficticios com sucesso no Chrome
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta e clico em register
    Entao a conta deve ser criada com sucesso

  @CadastroFelizF @Firefox
  Cenario: criar o cadastro de um novo cliente no sistema com dados ficticios com sucesso no Firefox
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta e clico em register
    Entao a conta deve ser criada com sucesso

  @CadastroExcecaoC @Chrome
  Esquema do Cenario: criar o cadastro de um novo cliente no sistema com dados ficticios no Chrome
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta menos o campo "<vCampo>" e clico em register
    Entao deve apresentar a mensagem "<vMsgErro>"

    Exemplos: 
      | Cenario                   | vCampo     | vMsgErro                                                                         |
      | não digitar primeiro nome | firstname  | firstname is required.                                                           |
      | não digitar sendo nome    | lastname   | lastname is required.                                                            |
      | não digitar a senha       | passwd     | passwd is required.                                                              |
      | não digitar o telefone    | phone      | You must register at least one phone number.                                     |     
      | não digitar a cidade      | city       | city is required.                                                                |
      | não digirar o cep         | Zip/Postal | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
      
 @CadastroExcecaoF @Firefox
  Esquema do Cenario: criar o cadastro de um novo cliente no sistema com dados ficticios no Firefox
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E na tela de autenticação em create an account no campo email eu digito o email e clico em create an account
    E preencho todo os campos obrigatorio para criação de conta menos o campo "<vCampo>" e clico em register
    Entao deve apresentar a mensagem "<vMsgErro>"

    Exemplos: 
      | Cenario                   | vCampo     | vMsgErro                                                                         |
      | não digitar primeiro nome | firstname  | firstname is required.                                                           |
      | não digitar sendo nome    | lastname   | lastname is required.                                                            |
      | não digitar a senha       | passwd     | passwd is required.                                                              |
      | não digitar o telefone    | phone      | You must register at least one phone number.                                     |     
      | não digitar a cidade      | city       | city is required.                                                                |
      | não digirar o cep         | Zip/Postal | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
      
      