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
  dockerfile = "Dockerfile"
  tags = ["singhkunal30/accounts-service:latest"]
}

target "cards-service" {
  context = "./cards-service"
  dockerfile = "Dockerfile"
  tags = ["singhkunal30/cards-service:latest"]
}

target "config-server" {
  context = "./config-server"
  dockerfile = "Dockerfile"
  tags = ["singhkunal30/config-server:latest"]
}

target "eureka-server" {
  context = "./eureka-server"
  dockerfile = "Dockerfile"
  tags = ["singhkunal30/eureka-server:latest"]
}

target "loans-service" {
  context = "./loans-service"
  dockerfile = "Dockerfile"
  tags = ["singhkunal30/loans-service:latest"]
}
