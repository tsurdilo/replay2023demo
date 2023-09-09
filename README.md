# Temporal Replay 2023 Demo

# start worker
mvn clean install
docker-compose up --build --detach

# scale to 2 workers
docker-compose up -d --build --scale replaydemo-worker=2
