package com.example.demo.controller;

import com.example.demo.config.securityConfig.CustomUserDetailsService;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.UserRolePermissions;
import com.example.demo.service.JwtBlacklistService;
import com.example.demo.service.UserRolePermissionsService;
import com.example.demo.utils.JSONResult;
import com.example.demo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.DataStatisticService;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtBlacklistService jwtBlacklistService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private DataStatisticService dataStatisticService;
    @Autowired
    private UserRolePermissionsService userRolePermissionsService;

    // 定义常量
    private static final String SUCCESS_MSG = "获取jwt成功";
    private static final String FAILURE_MSG = "认证失败";
    /**
     * 认证
     * @param authenticationRequest 包含用户名和密码的认证请求对象
     * @return 返回包含JWT令牌的响应结果
     */
    @PostMapping("/authenticate")
    public ResponseEntity<JSONResult> createAuthenticationToken(@Param("userId") Integer userId, @RequestBody JwtRequest authenticationRequest) {
        try {
            log.info("收到认证请求，用户名: {}", authenticationRequest.getUsername());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            final UserDetails userDetails = customUserDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success", statusCode, SUCCESS_MSG, jwt);
            log.info("qqqqqq");



            //添加用户登录信息  更新用户登录状态
            UserRolePermissions res = userRolePermissionsService.getUserIdByUserName(authenticationRequest.getUsername());
            res.setUserStatus(1);
            userRolePermissionsService.update(res);
//            Integer userid = res.getUserId();
//            log.info("userid:{}", userid);

            dataStatisticService.userLoginInsert(userId, authenticationRequest.getUsername());

            return ResponseEntity.ok(jsonResult);
        } catch (BadCredentialsException e) {
            int statusCode = HttpStatus.UNAUTHORIZED.value();
            JSONResult jsonResult = new JSONResult("error", statusCode, "用户名或密码错误", null);
            return ResponseEntity.ok(jsonResult);
        } catch (Exception e) {
            int statusCode = HttpStatus.UNAUTHORIZED.value();
            JSONResult jsonResult = new JSONResult("error", statusCode, FAILURE_MSG, null);
            return ResponseEntity.ok(jsonResult);
        }
    }

    /**
     * 注销
     * @param request 包含JWT的请求对象
     * @return 返回注销结果
     */
    @PostMapping("/logout")
    public ResponseEntity<JSONResult> logout(@Param("userName") String userName, HttpServletRequest request) {
        log.info("logout");

        // 从HTTP请求的头部获取授权信息
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }
        if (jwt != null) {
            jwtBlacklistService.addToBlacklist(jwt);
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success", statusCode, "注销成功", null);


//             获取当前用户名
//            String userName = SecurityContextHolder.getContext().getAuthentication().getName();

//            String userName = jwtUtil.extractUsername(jwt);

            //            更新用户登出信息  更新用户登录状态
            UserRolePermissions res = userRolePermissionsService.getUserIdByUserName(userName);
            res.setUserStatus(0);
            userRolePermissionsService.update(res);


//            Integer userId = userRolePermissionsService.getUserIdByUserName(userName).getUserId();


            dataStatisticService.updateLogOutInfo(userName);
            log.info("用户名:" + userName + "已注销");


            return ResponseEntity.ok(jsonResult);
        } else {
            int statusCode = HttpStatus.BAD_REQUEST.value();
            JSONResult jsonResult = new JSONResult("error", statusCode, "无效的JWT", null);
            return ResponseEntity.ok(jsonResult);
        }
    }
}


// JwtRequest 和 JwtResponse 是简单的POJO类，用于接收和返回JSON数据