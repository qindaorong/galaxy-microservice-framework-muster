package com.galaxy.microservice.user.core.controller;

import com.galaxy.microservice.user.api.remote.PermissionServiceFacade;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.user.core.entity.SysMenu;
import com.galaxy.microservice.user.core.service.PermissionService;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController implements PermissionServiceFacade {
    @Autowired
    private PermissionService permissionService;

    @Override
    @GetMapping("/getRolePermission/{roleId}")
    public ResponseResult<List<MenuVo>> getRolePermission(@PathVariable("roleId") Long roleId){
        List<SysMenu> menuList = permissionService.getPermissionsByRoleId(roleId);
        List<MenuVo> voList = new ArrayList<>();
        MenuVo vo;
        for(SysMenu menu : menuList){
            vo = new MenuVo();
            BeanUtils.copyProperties(menu,vo);
            voList.add(vo);
        }
        return ResponseResult.success(voList);
    }

}
