#language:pt
#Author: Vinicius Marra Santos
@Login
Funcionalidade: testes de login do sistema

  @LoginOkC @Chrome
  Cenario: faço login no sistema com sucesso no Chrome
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E em sing in na aba ALREADY REGISTERED no campo email eu digito e email "ffiliperenatokauedossantos@ctlive.com.br" e no campo senha eu digito a senha "janh3tWhgy"
    E em sing in na aba ALREADY REGISTERED clico em Sing In
    Entao devo ser logado com sucesso com o usuario "Filipe Renato Kauê dos Santos"

  @LoginOkF @Firefox
  Cenario: faço login no sistema com sucesso no Firefox
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E em sing in na aba ALREADY REGISTERED no campo email eu digito e email "vicenteryanthalesaparicio_@accor.com.br" e no campo senha eu digito a senha "eSBHTAj59X"
    E em sing in na aba ALREADY REGISTERED clico em Sing In
    Entao devo ser logado com sucesso com o usuario "Vicente Ryan Thales Aparício"

  @LoginExcecaoC @Chrome
  Esquema do Cenario: faço login no sistema com falha no Chrome
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E em sing in na aba ALREADY REGISTERED no campo email eu digito e email "<email>" e no campo senha eu digito a senha "<senha>"
    E em sing in na aba ALREADY REGISTERED clico em Sing In
    Entao deve apresentar a mensagem de erro "<vMsgErro>"

    Exemplos: 
      | email           | senha      | vMsgErro                   |
      |                 | eSBHTAj59X | An email address required. |
      | teste@teste.com |            | Password is required.      |
      | teste           | eSBHTAj59X | Invalid email address.     |

  @LoginExcecaoF @Firefox
  Esquema do Cenario: faço login no sistema com falha no Firefox
    Dado que eu acesse o site "http://automationpractice.com/index.php"
    Quando clico em Sign In
    E em sing in na aba ALREADY REGISTERED no campo email eu digito e email "<email>" e no campo senha eu digito a senha "<senha>"
    E em sing in na aba ALREADY REGISTERED clico em Sing In
    Entao deve apresentar a mensagem de erro "<vMsgErro>"

    Exemplos: 
      | email           | senha      | vMsgErro                   |
      |                 | eSBHTAj59X | An email address required. |
      | teste@teste.com |            | Password is required.      |
      | teste           | eSBHTAj59X | Invalid email address.     |
