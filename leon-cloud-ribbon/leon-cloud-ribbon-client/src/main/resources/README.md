在无Eureka 环境下如何运行Spring Cloud RIbbon 提供的负载均衡？修改一下application.yml配置

```yaml
ribbon:
  eureka:
    enabled: false #禁用eurake
# 禁用 Eureka 后手动配置服务地址
fw-cloud-ribbon-server: #服务名称
  ribbon:
    listOfServers: localhost:8773,localhost:8774
```