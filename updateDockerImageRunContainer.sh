#!/bin/bash

# Stop and remove the container
docker compose --file docker-compose-local.yml down

# Remove the image
docker rmi todo-app:latest
#Build todo-app docker image
docker build -t todo-app:latest .

docker compose --file docker-compose-local.yml up --build