package com.galaxy.microservice.user.core.controller;

import com.galaxy.microservice.user.api.remote.RoleServiceFacade;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.user.core.entity.SysRole;
import com.galaxy.microservice.user.core.service.RoleService;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController implements RoleServiceFacade {
    @Autowired
    private RoleService roleService;

    @Override
    @GetMapping("/getRoleByUserId/{userId}")
    public ResponseResult<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId){
        List<SysRole> roleList = roleService.getRoleByUserId(userId);
        List<RoleVo> voList = new ArrayList<>();
        RoleVo vo;
        for(SysRole role : roleList){
            vo = new RoleVo();
            BeanUtils.copyProperties(role,vo);
            voList.add(vo);
        }
        return ResponseResult.success(voList);
    }

}
