### zk-client

```yml
spring:
  application:
    name: zk-client
  cloud:
    zookeeper:
      connect-string: localhost:2081
      discovery:
        register: true
        enabled: true
        instance-id: 1
        root: /shenniu
server:
  port: 7061
```