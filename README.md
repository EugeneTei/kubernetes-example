# kubernetes-example

## Run Locally

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

