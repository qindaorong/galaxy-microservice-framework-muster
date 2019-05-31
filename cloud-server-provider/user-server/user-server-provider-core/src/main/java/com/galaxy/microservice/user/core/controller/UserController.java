package com.galaxy.microservice.user.core.controller;

import com.galaxy.microservice.user.api.exceptions.UserExceptionCode;
import com.galaxy.microservice.user.api.remote.UserServiceFacade;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.user.core.entity.SysUser;
import com.galaxy.microservice.user.core.service.UserService;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController implements UserServiceFacade {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/findByUsername/{username}")
    public ResponseResult<UserVo> findByUsername(@PathVariable("username") String username){
        SysUser user = userService.findByUsername(username);
        if (user == null){
            return new ResponseResult(UserExceptionCode.USER_NOT_EXIST);
        }
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user,vo);

        return ResponseResult.success(vo);
    }
}
