### GALAXY微服务服务框架
> 以springCloud为基础架构完成搭建的微服务集成运营框架

#### GALAXY微服务服务框架包结构说明
* 网关层接入方
    + cloud-base-provider       【基础服务】
        + cloud-distribute-lock 【分布式锁】
        + cloud-log             【日志分析】
        + cloud-mq              【mq功能集合】
            + cloud-kafka       【kafka功能集合】
                + kafka-consumer       【kafka-消费者模块】
                + kafka-provider       【kafka-生产者模块】
            + cloud-openApi     【openApi功能集合】
            + cloud-rabbit      【rabbit功能集合】
                + rabbit-consumer       【rabbit-消费者模块】
                + rabbit-provider       【rabbit-生产者模块】
            + cloud-rocket      【rocket功能集合】
                + rocket-consumer       【rocket-消费者模块】
                + rocket-provider       【rocket-生产者模块】
        + cloud-orm-mysql       【mysql数据持久层框架】
        + cloud-orm-redis       【redis数据持久层框架】
        + cloud-oss             【云存储】
        + cloud-swagger         【swagger服务】
        + cloud-util            【通用工具集合】
        + cloud-web             【web服务组件模块】
    + cloud-config              【rom配置服务中心】
        + cloud-apollo          【apollo配置中心】
        + cloud-disconf         【disconf配置中心】
        + cloud-gitconfig       【github配置中心】
    + cloud-gateway             【网关】
        + cloud-gateway         【基于gateway网关】
        + cloud-zuul            【基于zuul网关】
    + cloud-monitor             【监控】
        + cloud-es              【日志收集分析elk】
        + cloud-zipkin          【服务链路追踪】
    + cloud-oauth               【权限服务】
        + cloid-shiro-server    【基于shiro权限服务】
        + cloud-oauth2-server   【基于oauth2权限服务】
    + cloud-platfrom            【终端管理】
        + cloud-back            【后台管理页面】
        + cloud-openapi         【公开api对接服务】
    + cloud-register            【微服务注册中心】
        + cloud-consul          【基于consul微服务注册中心】
        + cloud-eureka          【基于eureka微服务注册中心】
        + cloud-zookeeper       【基于zookeeper微服务注册中心】
    + cloud-server-provider     【服务提供方】
        + cloud-server          【服务提供方】
            + cloud-server-provider-api     【服务提供方-接口层】
            + cloud-server-provider-core    【服务提供方-实现层】
    + cloud-task                【定时任务管理】
        + cloud-server-task-api         【定时任务服务治理-接口层】
        + cloud-server-task-core        【定时任务服务治理-实现层】
    + cloud-parent              【框架version统一管理】


    

