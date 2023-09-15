# Temporal Replay 2023 Demo

# start service
      
    docker network create temporal-network
    docker compose -f compose-postgres.yml -f compose-services.yml up --detach

# start worker

    mvn clean install
    docker-compose up --build --detach

# scale to 5 workers

    docker-compose up -d --build --scale replaydemo-worker=5


