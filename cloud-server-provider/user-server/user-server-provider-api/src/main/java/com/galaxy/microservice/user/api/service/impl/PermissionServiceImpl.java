package com.galaxy.microservice.user.api.service.impl;


import com.galaxy.microservice.user.api.service.PermissionService;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 11:14
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public ResponseResult<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败","getRolePermission");
        return ResponseResult.fail(100,"调用getRolePermission失败");
    }
}
