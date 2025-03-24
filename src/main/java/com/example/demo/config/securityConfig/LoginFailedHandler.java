package com.example.demo.config.securityConfig;

import com.alibaba.fastjson.JSON;
import com.example.demo.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class LoginFailedHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("##########################    登录失败处理逻辑！     ##########################");
        JSONResult jsonResult = JSONResult.build();
        if (exception instanceof AccountExpiredException) {
            //账号过期
            jsonResult.setResultCode(2002);
            jsonResult.setResultMsg("账号已过期!");
        } else if (exception instanceof BadCredentialsException) {
            //密码错误
            jsonResult.setResultCode(2004);
            jsonResult.setResultMsg("密码错误!");
        } else if (exception instanceof CredentialsExpiredException) {
            //密码过期
            jsonResult.setResultCode(2003);
            jsonResult.setResultMsg("密码过期!");
        } else if (exception instanceof DisabledException) {
            //账号不可用
            jsonResult.setResultCode(2005);
            jsonResult.setResultMsg("账号不可用!");
        } else if (exception instanceof LockedException) {
            //账号锁定
            jsonResult.setResultCode(2006);
            jsonResult.setResultMsg("账号被锁定!");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            //用户不存在
            jsonResult.setResultCode(2010);
            jsonResult.setResultMsg("账号不存在!");
        }else{
            //其他错误
            jsonResult.setResultCode(500);
            jsonResult.setResultMsg("未知错误!");
        }
        jsonResult.setType("error");
        //处理编码方式，防止中文乱码的情况
        response.setContentType("application/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(jsonResult));
        out.flush();
        out.close();
    }
}
