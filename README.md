# kubernetes-example

## Run Locally

Setup
```
docker compose -f setup/docker-compose.yaml up -d
```

Build Application
```
mvn clean package
```

Build Docker Image
```
docker build -t kubernetes-example/springboot:1.0 .
```

Kubernetes deployment
```
kubectl apply -f ./manifests/application/
```

