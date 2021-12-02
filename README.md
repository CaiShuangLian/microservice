# SpringCloud学习文档

## 一、项目基本架构

父工程：microservice

包含：

1.microservice-api：主要是一些公共模块

2.microservice-consumer-XXX：消费者

3.microservice-provider-XXX：服务提供者

4.microservice-eureka-XXX：注册中心



消费者，服务提供者和注册中心构成微服务的三大角色。

provider提供服务，eureka用于服务协调，负载均衡，容错和路由等

