package com.galaxy.microservice.oauth2.security;


import com.galaxy.microservice.oauth2.service.PermissionServiceClient;
import com.galaxy.microservice.oauth2.service.RoleServiceClient;
import com.galaxy.microservice.oauth2.service.UserServiceClient;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import com.galaxy.microservice.util.exception.CoreExceptionCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class GalaxyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceClient userServiceClient;
    @Autowired
    private RoleServiceClient roleServiceClient;
    @Autowired
    private PermissionServiceClient permissionServiceClient;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {

        ResponseResult<UserVo> userResult = userServiceClient.findByUsername(username);
        if (Objects.equals(userResult.getMeta(),CoreExceptionCodes.SUCCESS)) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userResult.getData(),userVo);
        ResponseResult<List<RoleVo>> roleResult = roleServiceClient.getRoleByUserId(userVo.getId());
        if (Objects.equals(roleResult.getMeta(),CoreExceptionCodes.SUCCESS)){
            List<RoleVo> roleVoList = roleResult.getData();
            for (RoleVo role:roleVoList){
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                ResponseResult<List<MenuVo>> perResult  = permissionServiceClient.getRolePermission(role.getId());
                if (Objects.equals(perResult.getMeta(),CoreExceptionCodes.SUCCESS)){
                    List<MenuVo> permissionList = perResult.getData();
                    for (MenuVo menu:permissionList
                    ) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }
        org.springframework.security.core.userdetails.User user = new User(userVo.getUsername(), userVo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);

        return user;
    }


}
