<img src="https://storage.googleapis.com/golden-wind/experts-club/capa-github.svg" />

## Auditoria de dados utilizando Javers ou Hibernate Envers em Java

Aula visando exemplificar a implementação de auditoria de dados, sendo assim, vamos exemplicar com as duas ferramentas relevanres na auditoria em Java, para isso vamos criar um projeto para o Hibernate Envers e outra para o Javers. A autoria nos permite verificar as altreações que foram realizadas nos dados de nossa aplicação e dependendo caso seja necessário rever alguma modicação no mesmo. 


### Ambiente
Abaixo encontramos o ambiente necessário para confecção do exemplo:

- JDK 11 ou superior
- Projeto com o Spring, para isso faça uso [Spring Initializr](https://start.spring.io/)
- Docker
- Postgres
- IDE

### Banco de Dados

Neste projeto será utilizado a base de dados postgres, para isso vamos usar o docker, abaixo temos o comando subindo a porta `5432` e com a senha `mysecretpassword`.

```sh
    docker run --name some-postgres  -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres
```

Após acesse o container que estiver rodando para criar as base de dados:

```sh
    docker exec -it some-postgres /bin/bash
```

Rode o seguinte comando no bash para acessar o postgres:

```sh
    psql -U postgres
```

Em seguida rode os seguintes comandos no postgres:

```postgres
    CREATE DATABASE envers WITH ENCODING 'UTF8';
    CREATE DATABASE javers WITH ENCODING 'UTF8';    
```

### Diretório do Projeto

> Em seguida irémos descrever o diretório principal do projeto:

```sh
.
├── audit-envers/ # Projeto com o hibernate envers habilitado
├── audit-javers/ # Projeto com o javers habilitado
├── .gitignore    # arquivos que devem ser ignorados
├── slides.pdf    # slides utilizados durante a aula
└── README.md
```

> Vamos explicar o que cada arquivo faz dentro do diretório do envers.

```sh
.
├── ...
├── audit-envers/src/main/br/com/rocketseat/expert/club/auditenvers                
│   ├── AuditorAwareImpl.java   # adicionar o usuário quando usa auditoria usando spring audit       
│   ├── Config.java  # cria os beans necessários para execução da aplicação        
│   ├── DemoApplication.java # arquivo priniciapl que será chamado para subir o resto da aplicação
│   ├── Tutorial.java # entidade do projeto que será auditada
│   ├── TutorialController.java  # controller que viabiliza a alteração da entidade
│   ├── TutorialRepoistory.jae # cria a relação entre a base de dados e a entidade
│   ├── TutorialService.jave # contecta o mudo exterior o controller com a regra de negócio.
│   ├── UserRevEntity.java # entidade que altera a entidade básica do envers para permitir armazenar o usuário, que realizou determinada ação.
│   └── UserRevisionListener.java # listener que fica escutando que uma entidade foi alterar para capturar o usuário que realizou determinada ação. 
└── ...
```

> Vamos explicar o que cada arquivo faz dentro do diretório do javers.

```sh
.
├── ...
├── audit-javers/src/main/br/com/rocketseat/expert/club/auditjavers                     
│   ├── TutorialConfig.java  # Cria o Bean que será utilizado para capturar o usuário da alteração e adiciona um propriedade no commit de acordo com o tipo de entidade.         
│   ├── DemoApplication.java # arquivo priniciapl que será chamado para subir o resto da aplicação
│   ├── Tutorial.java # entidade do projeto que será auditada
│   ├── TutorialController.java  # controller que viabiliza a alteração da entidade
│   ├── TutorialRepoistory.jae # cria a relação entre a base de dados e a entidade
│   ├── TutorialService.jave # contecta o mudo exterior o controller com a regra de negócio.
└── ...
```

## Expert

| [<img src="https://avatars.githubusercontent.com/u/1785791?s=400&u=cf86c9ae2216765f948ca2136eda7e632e0cd922&v=4" width="75px;"/>](https://github.com/gustavodsf) |
| :-: |
|[Gustavo Figueiredo](https://github.com/gustavodsf)|