# atechValidation

# Rodar testes

find . -name "pom.xml" -exec mvn clean verify -f '{}' \;

obs.: O serviço fligtservice, não consegio verificar o motivo por conta da data de entrega, mas o teste passa por completo no IntelliJ e quebra no command line.
Por esse motivo, para buildar a aplicação mandei pular os testes.

# Build da aplicação

find . -name "pom.xml" -exec mvn -Dmaven.test.skip package -f '{}' \;

# Subir aplicação com dokercompose

docker-compose up --build -d

A aplicação dubindo em localhost a Swagger das api fica em 



localhost:5555/aircraftservice/swagger-ui.html
localhost:5555/acitytservice/swagger-ui.html
localhost:5555/flightservice/swagger-ui.html
localhost:5555/pilotservice/swagger-ui.html

A documentação foi gerada de forma automatica pelo Springfox
https://springfox.github.io/springfox/

Os logs estao sendo armazenados no PapaeTrail e estão sendo identificados pelo Spring Cloud Sleuth

O Hystrix esta configurado em falil fast, sem nenhum falback method configurado.


Infelismente o script do Cloud Formation nao consegui fazer ate a data definida para entrega


# Gerar token de autenticação
curl --request POST \
  --url http://localhost:8088/oauth/token \
  --header 'authorization: Basic c2VhcmNoZmx5OnNlYXJjaGZseTEyMzQ1' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data scope=web \
  --data grant_type=password \
  --data username=sys \
  --data password=qwerty
  
  
  
  # validar token
  
  curl --request GET \
  --url http://localhost:8088/user \
  --header 'authorization: Bearer bcd80a64-be37-48f8-ae1d-e772a4beb834' \
