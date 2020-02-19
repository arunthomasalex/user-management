# Steps to run the application in a dockercontainer
## Mariadb Configuration:
Download and install mariadb using the command below, it also maps the port 3306 of the docker to 6033 for an application out side the docker to access:
* docker run -d -p 6033:3306 --name=docker-mariadb --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=usermanagement" mariadb:10.5

Run the script in the resorce folder using the command:
* docker exec -i docker-mariadb mysql -uroot -proot usermanagement <run_schema.sql

Opens the terminal for the container docker-mariadb(this step is not required for setting up the application):
* docker exec -it docker-mariadb bash


## Spring boot application configuration:
Build the spring boot appliction with the following command:
* gradlew bootJar

Build an image for the alredy build spring boot application:
* docker build -t usermanagement .

Run the first command for getting the container id and then execute the next command to start the spring boot application
* docker container ls
* docker run -t --link **${mariadb-container-id}**:docker-mariadb -p 8080:8080 usermanagement
