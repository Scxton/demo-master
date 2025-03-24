package com.example.demo.config.securityConfig;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.UserRolePermissions;
import com.example.demo.service.DataStatisticService;
import com.example.demo.utils.JSONResult;
import com.example.demo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    public LoginSuccessHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private DataStatisticService statisticService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("##########################    登录成功处理逻辑！     ##########################");

        //修改添加在线时长统计
        //String username = authentication.getName();



        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            throw new IllegalStateException("No user information found in the security context");
        }

        UserRolePermissions loginUser;
        if (principal instanceof UserRolePermissions) {
            loginUser = (UserRolePermissions) principal;
        } else if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            // 根据实际情况处理 UserDetails 对象
            loginUser = convertToUserRolePermissions(userDetails);
        } else {
            log.warn("Unknown principal type: {}", principal.getClass().getName());
            return;
        }

        try {
            handleLoginSuccess(response, loginUser);
        } catch (Exception e) {
            log.error("Failed to generate token or write response", e);
            throw new ServletException("Authentication success handling failed", e);
        }
    }

    private void handleLoginSuccess(HttpServletResponse response, UserRolePermissions loginUser) throws IOException {
        String token = jwtUtil.generateToken(loginUser.getUserName());
        response.setHeader("token", token);
        writeResponse(response, "登录成功", loginUser);
    }
    private void writeResponse(HttpServletResponse response, String message, Object data) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            JSONResult resultBean = JSONResult.ok(message, data);
            out.write(JSON.toJSONString(resultBean));
            out.flush();
        }
    }

    private UserRolePermissions convertToUserRolePermissions(UserDetails userDetails) {
        // 这里可以根据你的业务逻辑进行转换
        // 从 userDetails 获取用户名、角色等信息，并创建一个 UserRolePermissions 对象
        UserRolePermissions userRolePermissions = new UserRolePermissions();
        userRolePermissions.setUserName(userDetails.getUsername());
        return userRolePermissions;
    }
}

