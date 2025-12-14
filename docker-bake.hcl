variable "PLATFORMS" {
  default = ["linux/amd64", "linux/arm64"]
}

group "default" {
  targets = [
    "accounts-service",
    "cards-service",
    "config-server",
    "eureka-server",
    "loans-service",
    "gateway-server"
  ]
}

target "accounts-service" {
  context = "./accounts-service"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS  #
  tags = ["singhkunal30/accounts-service:latest"]
}

target "cards-service" {
  context = "./cards-service"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS
  tags = ["singhkunal30/cards-service:latest"]
}

target "config-server" {
  context = "./config-server"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS
  tags = ["singhkunal30/config-server:latest"]
}

target "eureka-server" {
  context = "./eureka-server"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS
  tags = ["singhkunal30/eureka-server:latest"]
}

target "loans-service" {
  context = "./loans-service"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS
  tags = ["singhkunal30/loans-service:latest"]
}

target "gateway-server" {
  context = "./gateway-server"
  dockerfile = "Dockerfile"
  platforms = PLATFORMS
  tags = ["singhkunal30/gateway-server:latest"]
}