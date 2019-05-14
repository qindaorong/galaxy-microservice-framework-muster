### 星河互联swagger集成框架
对应每个独立服务提供架构集成swagger使用

### 使用介绍
在项目配置文件中添加以下配置

```
#swagger配置说明(中文需要转码)
swagger.info.title=demo项目模板
swagger.info.description=demo项目模板
swagger.info.version=v1.0.0
swagger.info.base-package=*******
swagger.info.enable=true
```

### 其他配置
在对应controller上添加对应标签修饰。

### swagger 页面访问
http://{ip}:{port}/swagger-ui.html

