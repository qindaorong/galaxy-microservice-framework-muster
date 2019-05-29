package com.galaxy.microservice.oauth2.security;

import com.galaxy.microservice.oauth2.entity.Authority;
import com.galaxy.microservice.oauth2.entity.User;
import com.galaxy.microservice.oauth2.service.AuthorityService;
import com.galaxy.microservice.oauth2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class GalaxyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        String lowercaseLogin = login.toLowerCase();
        log.debug("GalaxyUserDetailsService lowercaseLogin is [{}]!",lowercaseLogin);

        User user = userService.findByUserMobileCaseInsensitive(lowercaseLogin);
        if (user == null) {
            //throw new BusinessException(FrameworkExceptionCode.UserCode.USER_INEXISTENCE);
        }

        //获取用户的所有权限并且SpringSecurity需要的集合
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Authority> authorityList = authorityService.findAuthorityByUserId(user.getId());
        for (Authority authority : authorityList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        //返回一个SpringSecurity需要的用户对象
        return new org.springframework.security.core.userdetails.User( user.getMobile(),
                user.getPassword(),
                grantedAuthorities);
    }


}
