# memories
A video sharing application

# Data Model
please find the chebotko diagram in the root directory.

# Using Docker
1. Start the docker
2. navigate to project folder
3. run the command docker-compose up [ this will fetch the cassandra image and starts it ]
4. open another termnial and run a command "docker ps" to check the running contaners. Make sure mycassandra is running.
5. Once the container is up, enter into bash mode in container with command, "docker exec -it (container id) bash".
6. type cqlsh to enter into cassandra shell

# Table creation 
Please run the scripts from scripts.txt in the cassandra terminal

# Run the application in any IDE
Either Run the MemoriesApplication in GUI of any IDE or use "mvn spring-boot:run" command in terminal if maven is installed locally.

# Mock data
Please find the mockdata.txt file and post them using postman.

# Postman Collection
I am adding the collection JSON (memories.postman_collection.json). Just import this into Postman and you can find all the API requests.

# Documentation
please go through the document.md to get an idea of all the models, desriptions, endpoints.
