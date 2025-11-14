Relatório do Projeto FEI Food 

1. Introdução 

O presente relatório tem como objetivo documentar o desenvolvimento do projeto FEI Food – Sistema de Pizzaria, criado para a disciplina da faculdade. O sistema consiste em uma aplicação Java desktop estruturada com MVC (Model-View-Controller) e conectada a um banco de dados PostgreSQL, gerenciado via pgAdmin. 

O FEI Food foi idealizado como uma pizzaria interna dentro do sistema, permitindo que o usuário: 

Crie um cadastro 

Faça login 

Acesse um menu interno 

Altere sua senha 

Exclua sua conta 

Busque uma pizza pelo nome 

Cadastre pedidos 

Crie pizzas personalizadas com ingredientes salgados e doces 

A aplicação foi desenvolvida utilizando Java Swing, JDBC, PostgreSQL, pgAdmin, além de uma organização profissional em pacotes seguindo boas práticas de projeto. 

 

2. Estrutura do Projeto 

O sistema foi organizado em pacotes conforme boas práticas do padrão MVC: 

/controller 
/model 
/view 
/dao 
 

● model/ 

Contém a classe Aluno, representando o usuário do sistema. 

● dao/ 

Armazena a lógica de acesso ao banco de dados, incluindo: 

Conexao.java 

AlunoDAO.java 

● controller/ 

Responsável pelo fluxo de lógica entre interface e banco: 

ControleLogin.java 

ControleCadastro.java 

● view/ 

Contém todos os formulários Swing usados na interface gráfica: 

Login 

Cadastro 

Logado 

Alterar Senha 

Buscar Pizza 

Cadastrar Pedido 

Criar Pizza Personalizada 

 

3. Banco de Dados e Uso do pgAdmin 

A infraestrutura do banco foi implementada utilizando PostgreSQL 18 e administrada via pgAdmin. 

A tabela principal é: 

CREATE TABLE alunos ( 
   id SERIAL PRIMARY KEY, 
   nome VARCHAR(100), 
   usuario VARCHAR(50) UNIQUE, 
   senha VARCHAR(50) 
); 
 

O pgAdmin foi essencial para: 

Criar o banco e tabelas 

Visualizar cadastros 

Testar queries SQL 

Debugar autenticação 

Verificar alterações de senha e exclusões 

A aplicação se conecta ao banco através de JDBC usando a classe Conexao.java. 

 

4. Funcionalidades Implementadas 

✔ 4.1 Tela de Login 

Permite que o usuário insira seu usuário e senha. 
Caso as credenciais estejam corretas, o sistema abre a tela principal (Logado). 

Agora totalmente funcional após correções no DAO e na conexão PostgreSQL. 

 

4.2 Cadastro de Usuário 

O usuário informa Nome, Usuário e Senha. 
Os dados são enviados ao banco usando: 

ControleCadastro 

AlunoDAO.inserir() 

 

4.3 Tela Principal – “Logado” 

Após o login, o usuário acessa o menu: 

Buscar por pizza 

Cadastrar pedido 

Personalizar pizza 

Alterar senha 

Excluir cadastro 

Sair 

Essa tela recebe o objeto Aluno logado e exibe o nome no topo. 

 

4.4 Alterar Senha 

O usuário insere uma nova senha. 
O sistema: 

Busca o usuário atual 

Atualiza a senha no banco 

Confirma o sucesso 

Interface simples, objetiva e funcional. 

 

4.5 Excluir Cadastro 

A função remove completamente o usuário da tabela alunos. 
Processo: 

Recebe o aluno logado 

Exibe confirmação 

Exclui via AlunoDAO.delete() 

Fecha o sistema ou volta ao login 

 

4.6 Cadastro de Pedido 

O usuário informa: 

Nome da pizza 

Quantidade 

Pode adicionar múltiplos itens no pedido. 
Também existe a opção Personalizar Pedido, que leva para a próxima seção. 

 

4.7 Criar Pizza Personalizada 

Uma das partes mais criativas do projeto. 

O usuário pode: 

Criar o nome da pizza 

Escolher ingredientes salgados 

Escolher ingredientes doces 

Adicionar o pedido à lista 

Os ingredientes incluem: 

Salgados: 
Calabresa, Frango, Bacon, Presunto, Catupiry, Tomate, Cebola, Milho, Azeitona, Mussarela, Palmito, Lombo 

Doces: 
Chocolate, Morango, Leite Condensado, Banana, Doce de Leite, Manga 

 

4.8 Buscar Pizza 

Permite digitar o nome de uma pizza e visualizar seus ingredientes, caso exista. 

 

5. Fluxo Geral do Sistema 

O usuário entra na tela de login 

Pode cadastrar um novo usuário 

Ao logar, acessa o menu principal 

Escolhe uma das ações: 

Buscar pizza 

Cadastrar pedido 

Personalizar pizza 

Alterar senha 

Excluir cadastro 

O banco de dados trata autenticação, atualizações e exclusões 

O sistema fecha ou retorna ao login dependendo da ação 

 

6. Uso do PostgreSQL e pgAdmin no Projeto 

O pgAdmin foi utilizado de forma essencial durante o desenvolvimento: 

Criação e gerenciamento da tabela alunos 

Testes manuais com SQL 

Verificação de registros inseridos pela aplicação 

Debug da autenticação com: 

SELECT * FROM alunos; 
 

Testes de dados durante cadastro, alteração e exclusão 

Garantia de unicidade do campo “usuário” 

O uso do PostgreSQL garante robustez, persistência e escalabilidade ao projeto. 

 

7. Conclusão 

O projeto FEI Food se desenvolveu como um sistema completo de pizzaria com: 

Cadastro de usuário 

Login integrado ao banco 

Menu funcional 

Criação de pedidos 

Sistema avançado de pizzas personalizadas 

Alteração e exclusão de conta 

Conexão estável com banco PostgreSQL 

Interface gráfica intuitiva feita em Swing 

Todas as funcionalidades previstas foram implementadas com sucesso. 

Além de cumprir os requisitos da disciplina, o sistema demonstra domínio de: 

Programação Orientada a Objetos 

Padrão MVC 

Banco de dados relacional 

SQL 

Manipulação de eventos e interfaces gráficas 

O FEI Food está estável, funcional e organizado, sendo um ótimo exemplo de aplicação desktop profissional. 
