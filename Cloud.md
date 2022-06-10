# Cloud

## Using spring-maven-plugin

````
./mvnw spring-boot:build-image

docker run -d -p 8080:8080  --name xxx -e "SPRING_PROFILES_ACTIVE=dev" ImageID

````
## Using Dockerfile(Multi-stage)

````
docker build ./ -t fago-multi

docker run -d -p 8080:8080  --name xxx -e "SPRING_PROFILES_ACTIVE=dev" ImageID

````