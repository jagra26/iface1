# iface1

#Funcionalidades
  #login
    
    #ode ser chamado no metodo "decisaoInicial", é acionado através do método "entrar", 
    que pede do usuario um login e uma senha
    ele checa se aquele login existe, e se existe, se a a senha é a mesma informada.
    caso seja, ele entra em um loop que chama o método "menuUser", espécie de menu, com as outras funcionalidades

  #logoff
    
    #dentro do método "menuUser", caso essa funcionalidade seja chamada, ela quebra o loop que foi explicado na 
    funcionalidade
    anterior e retorna ao loop inicial do programa.

  #novo usuario
    
    #pode ser chamado no metodo "decisaoInicial", é acionado através do método "novoUsuario", que pede as informações
    para um novo perfil, caso sejam dadas de forma correta, adiciona o usuario na rede, 
    imprime o login do novo perfil ao usuario. E chama o método "entrar".

  #adição de amigo
    
    #pode ser chamado no método "menuUser" através do método "solicitacao", ele recebe do usuario um login, 
    caso este seja existente, ele marca o login do usuario na lista de solicitações de amizade do usuario solicitado.
    
    #caso o usuario deseje ver as solicitações no metodo "menuUser" através do método "tratarSolicitacao", que percorre
    a lista de solicitacoes do perfil do usuario, checa se há solicitaçoes, valores diferentes de -1,
    caso hajam, há tres opções,
    aceitar, o solicitante é marcado como amigo na sua lista de amigos, e a solicitacao, na lista de solicitacao, recebe o 
    valor -1.
    recusar, a solicitacao recebe o valor de -1
    limbo, o metodo segue percorrendo a lista e deixa a solicitacao como valida
  
  #edição de perfil 
    
    #permite apenas a alteração do nome do usuario, é acionado pelo metodo "menuUser" através do método "edit" e muda o nome 
    do usuario, por outro informado por ele
    
  #envio de mensagens
    
    #através do metodo "dispMsg" há um menu com as funcionalidades 
    
    #nova mensagem, através do metodo "novaMsg" recebe, do usuario, as informações da mensagem e a adiciona na lista de 
    mensagens do destinatario
    
    #mensagens não lidas, percorre a lista de mensagens do usuario e imprime as mensagens ainda não lidas 
    e as marca como lidas, atraveś do método "msgNlidas"
    
    #mensagem do arroba, dado um login o metodo "msgDoArroba" percorre a lista de mensagens do usuario e imprime
    mensagens com o remetente igual ao login dado pelo usuario, e as marca como lidas
  
  #criaçao de comunidades
    
    #através do metodo "novaComunidade" o usuario cria uma nova comunidade, que é adicionada a lista de comunidades da rede.
    o usuario se torna administrador da comunidade. O método também informa o numero dessa nova comunidade
 
 #adição de membros numa comunidade
    
    #através do metodo "inserirComunidade" o usuario informa o numero da comunidade desejada, caso ele seja administrador 
    dela, abre espaço para o usuario adicionar alguém na comunidade, ao informar o login da pessoa, ele é adicionado 
    na lista de participantes da comunidade
    
    #através do metodo "entrarComunidade" o usuario informa o numero de uma comunidade e uma mensagem é enviada ao 
    administrador da comunidade solicitando a participação
  
  #recuperação de informações
    
    #o método "index" imprime as informações de todos os usuarios e comunidades cadastradas na rede
  
  #remoção de conta
    
    #chamada atraves do metodo "menuUser" pergunta se o usuario realmente tem certeza daquilo, caso sim, utiliza o método  
    "remove" da collection ArrayList e remove o perfil dele da rede. chamando o método "decisao inicial"
  
#Classes

  #Perfil
    
    #foi criada para guardar as informações de cada usuario
    contém nome, login, senha, lista de amigos, lista de comunidades que o usuario participa,
    e as mensagens do usuário.
    
    #A vantagem de ser simples, sem dificuldade de acessar as informações
  #Comunidade
  
    #foi criada para poder salvar as comunidades da rede
    contém o numero dela, na lista de comunidades da rede, um titulo, um inteiro que guarda o login do administrador
    e uma lista de inteiro que guarda o login de todos os participantes
    
    #A vantagem de ser simples, sem dificuldade de acessar as informações
  
  #Mensagem
    
    #foi criada para poder salvar as informações das mensagens trocadas na rede
    contém os logins do destinatário e do remetente, uma string com a mensagem em si e um booleano que marca se ela foi 
    ou não lida
    
    #A vantagem de ser simples, sem dificuldade de acessar as informações
  
  #Display
   
    #foi criada para tratar as interações entre usuario e máquina
    
    #tem a vantagem de ser seguro, pois não dá acesso livre as informações da rede
   
    #não é prática e tem que passar a rede como parametro de quase todos os métodos
  
  #Rede
    
    #foi criada para guardar todos os usuarios e comunidades
    contém duas listas, uma de perfis outra de comunidades
    
    #A vantagem de ser simples, sem dificuldade de acessar as informações
    
  #Tratamento de exceções
  
    #todas as funções que necessitam de informações advindas do usuario tem tratamento, implementadas com try catch
    tratamento para os erros InputMismatchException e IndexOutOfBoundsException
  
    #tem a vantagem de facilitar a usabilidade evitando que o sistema feche com erros acidentais ou propositais
  
  
