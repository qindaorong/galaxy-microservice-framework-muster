package com.galaxy.microservice.oss.aliyun.strategy;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.galaxy.microservice.oss.aliyun.param.AliRemoveParam;
import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import com.galaxy.microservice.oss.getway.factory.FileRemove;
import org.springframework.util.Assert;

public class AliYunRemove  extends AbstractAliStrategy implements FileRemove {

    private static final String FAIL_SUPPORT = "BaseFileDTO<T> type is not support";

    @Override
    protected Boolean support(FileParam param) {
        if(param instanceof AliRemoveParam){
            loadConfiguration();
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(BaseFileDTO<? extends FileParam> baseFileDTO) {

        Boolean isSupport = this.support(baseFileDTO.getParam());
        Assert.isTrue(isSupport,AliYunRemove.FAIL_SUPPORT);

        try {
            AliRemoveParam aliRemoveParam = (AliRemoveParam)baseFileDTO.getParam();
            ossClient.deleteObject(super.aliConfig.getBucketName(), aliRemoveParam.getUploadFilePath());

            return true;
        } catch (OSSException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return false;
    }

    private AliYunRemove(){
        if(AliYunRemove.LazyHolder.LAZY != null){
            throw new RuntimeException("AliYunRemove can not have multiple instance");
        }
    }

    public static final AliYunRemove getInstance(){
        return AliYunRemove.LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final AliYunRemove LAZY = new AliYunRemove();
    }
}
