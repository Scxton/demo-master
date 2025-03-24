package com.example.demo.config.securityConfig;

import com.example.demo.model.UserRolePermissions;
import com.example.demo.service.UserRolePermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRolePermissionsService userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRolePermissions user = userRepository.findByUserName(username);
        if (user == null) {
//            log.info("收到null 返回UsernameNotFound");
            throw new UsernameNotFoundException("用户不存在: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPwd(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRoleId().toString()))
        );
    }
}
