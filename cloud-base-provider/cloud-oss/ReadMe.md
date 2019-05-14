### 星河互联云存储通用框架
> 云存储聚合使用框架

#### 云存储介绍

> 云存储是一种网上在线存储（英语：Cloud storage）的模式，即把数据存放在通常由第三方托管的多台虚拟服务器，而非专属的服务器上。托管（hosting）公司营运大型的数据中心，需要数据存储托管的人，则透过向其购买或租赁存储空间的方式，来满足数据存储的需求。数据中心营运商根据客户的需求，在后端准备存储虚拟化的资源，并将其以存储资源池（storage pool）的方式提供，客户便可自行使用此存储资源池来存放文件或对象。实际上，这些资源可能被分布在众多的服务器主机上。

#### 聚合结构介绍

        1.com.galaxy.framework.cloud.getway
         > 调用入口，以及封装组件，框架代码等
         
        2.com.galaxy.framework.cloud.aliyun
         > 对应不同的oss框架，做的通道代码封装。
         > 不同的通道请封装在和aliyun同级别的不同目录下，其中的代码结构请参照aliyun。


#### 使用方法说明

a. 添加配置文件， 如下：

```Java
cloudStorage.ali.endpoint=https://oss-cn-beijing.aliyuncs.com
cloudStorage.ali.accessKeyId=LTAIhNXAi6guPxlW
cloudStorage.ali.accessKeySecret=Lz9YpCWnYTvFDr1EdtFiyGAlm5XIey
cloudStorage.ali.bucketName=youquhua
cloudStorage.ali.folder=
cloudStorage.ali.path=https://youquhua.oss-cn-beijing.aliyuncs.com/
```
b. 注入公共通道并选择使用通道：
```Java
//注入公共通道
@Autowired
private CloudDelegate cloudDelegate;


//封装公共参数，调用公共上传方法，并选择使用oss通道
byte[] bytes = IOUtils.toByteArray(new FileSystemResource("F:\\back_image\\1.jpg").getInputStream());
UploadDTO<AliUpLoadParam> uploadDTO = new UploadDTO<>();
uploadDTO.setFileBytes(bytes);
uploadDTO.setFileName("1.jpg");
AliUpLoadParam param = new AliUpLoadParam();
param.setUploadFilePath("qindaorong_test/");
uploadDTO.setParam(param);
cloudDelegate.upload(CloudStorageStrategy.AliYun,uploadDTO);
```

### 开发规则
* 新通道包结构说明
    + ___aliyun___（oss 实现通道）
        + ___factoryImpl___（工厂方法实现包）
            + AliYunStrategy（工厂方法实现类）
        + ___param___（通道方法参数封装包）
            + AliDownLoadParam（下载参数封装）
            + AliRemoveParam（删除参数封装）
            + AliUpLoadParam（上传参数封装）
        + ___strategy___（通道策略实现类）
            + AbstractAliStrategy（阿里OSS 抽象类--> 统一封装client）
            + AliYunDownload（下载方法实现）
            + AliYunRemove（删除方法实现）
            + AliYunUpload（上传方法实现）
* 其他修改类
    + **CloudStorageConfig**
        > 和内部类AliConfig平行添加新通道所需的配置文件。
    + **CloudStorageStrategy**
        > 添加对应通道枚举
