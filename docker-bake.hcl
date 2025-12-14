group "default" {
  targets = [
    "accounts-service",
    "cards-service",
    "config-server",
    "eureka-server",
    "loans-service"
  ]
}

target "accounts-service" {
  context = "./accounts-service"
  dockerfile = "./accounts-service/Dockerfile"
  tags = ["singhkunal30/accounts-service:latest"]
}

target "cards-service" {
  context = "./cards-service"
  dockerfile = "./cards-service/Dockerfile"
  tags = ["singhkunal30/cards-service:latest"]
}

target "config-server" {
  context = "./config-server"
  dockerfile = "./config-server/Dockerfile"
  tags = ["singhkunal30/config-server:latest"]
}

target "eureka-server" {
  context = "./eureka-server"
  dockerfile = "./eureka-server/Dockerfile"
  tags = ["singhkunal30/eureka-server:latest"]
}

target "loans-service" {
  context = "./loans-service"
  dockerfile = "./loans-service/Dockerfile"
  tags = ["singhkunal30/loans-service:latest"]
}
