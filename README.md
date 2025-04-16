# 🚀 Kanban Board

Api de tarefas que vai ser consumida pelo projeto kanban-frontend.

## 🛠️ Tecnologias

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## ✅ Pré-requisitos

Você precisará ter instalado:

- [Java 17+](https://adoptium.net/)
- [Docker](https://www.docker.com/get-started) (Opcional. Só precisa ser instalado caso for subir o banco via docker-compose)
- [Docker Compose](https://docs.docker.com/compose/install/) (Opcional. Só precisa ser instalado caso for subir o banco via docker-compose)
- [Git](https://git-scm.com/)
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/)

Verifique se estão instalados:

Verifique:

- java -version
- docker -v
- docker compose version
- mvn -v

Clonando o projeto:

- git clone https://github.com/ericmtfontes/kanban-backend.git

Subindo o banco de dados com Docker Compose:

- o projeto inclui um docker-compose.yml que sobe um container PostgreSQL
- docker-compose up

Configurando o Spring Boot:

- no arquivo application.properties ou application.yml, configure as seguintes variaveis de ambiente de acordo com as configurações do banco que está sendo utilizado:
- spring.application.name=kanban-board

- spring.datasource.url=${URL_DB}
- spring.datasource.username=${USERNAME_DB}
- spring.datasource.password=${PASSWORD_DB}
- spring.jpa.hibernate.ddl-auto=update

Executando a aplicação:

- ./mvnw spring-boot:run
- # ou
- mvn spring-boot:run

Acessando a aplicação:

- http://localhost:8080/tasks (geralmente o tomcat utiliza a porta 8080, porem é viável verificar em qual porta a aplicação subiu)
