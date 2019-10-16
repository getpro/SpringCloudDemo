mvn clean package
docker stop demo-api3
docker rm demo-api3
docker-compose   -f ./docker-compose-dev.yml up -d --build demo-api3
