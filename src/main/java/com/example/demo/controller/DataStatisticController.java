package com.example.demo.controller;
import com.example.demo.service.DataStatisticService;
import com.example.demo.model.DataStatistic;
import com.example.demo.service.UserRolePermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.utils.JSONResult;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("DataStatistic")
public class DataStatisticController {
    @Autowired
    private DataStatisticService dataStatisticService;
    @Resource
    private UserRolePermissionsService userRolePermissionsService;


    // 用户登录接口
//    @PostMapping("/login")
//    public ResponseEntity<JSONResult> userLogin(Integer userId, String userName) {
//        Integer res = dataStatisticService.userLoginInsert(userId, userName);
//        if(res > 0){
//            String msg = "Login successful！";
//            int statusCode = HttpStatus.OK.value();
//            JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
//            return ResponseEntity.ok(jsonResult);
//        }
//        return ResponseEntity.ok(JSONResult.error(400, "未成功记录用户登录时间！"));
//    }

    // 获取系统当前在线用户
    @GetMapping("/onlineUser")
    public ResponseEntity<JSONResult> countOnlineUser(){
        log.info("countOnlineUser");
        Integer res = dataStatisticService.countOnlineUser();
        log.info("countOnlineUser:{}", res);
        if(res > 0){
            String msg = "当前系统在线：" + res + "人";
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
            return ResponseEntity.ok(jsonResult);
        }
        return ResponseEntity.ok(JSONResult.error(400, "当前系统无人在线！"));
    }

    // 根据用户名获取用户的登录时间
    @GetMapping("/getLogInTimeByUsername")
    public ResponseEntity<JSONResult> getLogInTimeByUsername(String userName){
        log.info("getLogInTimeByUsername");
        String logInTime = dataStatisticService.getLogInTimeByUsername(userName);
        String msg = "用户：" + userName + "\n" +"登录时间为：" + logInTime;
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,logInTime);
        return ResponseEntity.ok(jsonResult);
    }

//     获取用户在线时长
    @GetMapping("/onlineUserDuration")
    public ResponseEntity<JSONResult> onlineUserDuration(String userName){
        log.info("onlineUserDuration");
        String duration_time = dataStatisticService.onlineUserDuration(userName);
        String msg = "当前在线时长为：" + duration_time;
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,duration_time);
        return ResponseEntity.ok(jsonResult);
    }


//    // 用户登出接口
//    @PostMapping("/logout")
//    public ResponseEntity<JSONResult> userLogout(String userName) {
//        // 登出时，记录登出时间和在线时长
//        dataStatisticService.userLogout(userName);
//        String msg = "Logout successful！";
//        int statusCode = HttpStatus.OK.value();
//        JSONResult jsonResult = new JSONResult("success",statusCode,msg,null);
//        return ResponseEntity.ok(jsonResult);
//    }
//
//    // 获取在线人数接口
//    @GetMapping("/onlineCount")
//    public ResponseEntity<JSONResult> getOnlineUserCount() {
//        Integer onlineCount = dataStatisticService.getOnlineUserCount();
//        String msg = "获取在线人数成功！";
//        int statusCode = HttpStatus.OK.value();
//        JSONResult jsonResult = new JSONResult("success",statusCode,msg,onlineCount);
//        return ResponseEntity.ok(jsonResult);
//    }
//
//    // 更新下载次数接口
//    @PostMapping("/updateDownloadCount")
//    public ResponseEntity<JSONResult> updateDownloadCount(Integer userId) {
//        Integer updatedDownloadCount = dataStatisticService.updateDownloadCount(userId);
//        //return ResponseEntity.ok(JSONResult.ok("下载次数更新成功", updatedDownloadCount));
//        String msg = "下载次数更新成功！";
//        int statusCode = HttpStatus.OK.value();
//        JSONResult jsonResult = new JSONResult("success",statusCode,msg,updatedDownloadCount);
//        return ResponseEntity.ok(jsonResult);
//    }
//
//    // 获取用户下载次数接口
//    @GetMapping("/downloadCount")
//    public ResponseEntity<JSONResult> getDownloadCount() {
//        Integer downloadCount = dataStatisticService.getDownloadCount();
//        String msg = "获取下载次数成功！";
//        int statusCode = HttpStatus.OK.value();
//        JSONResult jsonResult = new JSONResult("success",statusCode,msg,downloadCount);
//        return ResponseEntity.ok(jsonResult);
//    }
//    @Description("获取系统当前在线用户人数")
//    @RequestMapping(value = "/onlineUser", method = RequestMethod.GET)
//    public JSONResult countOnlineUser() {
//        Integer res = onlineDataService.countOnlineUser();
//        log.info("系统当前在线用户为"+ res +"欢迎回来！");
//        return JSONResult.ok("成功获取单位信息", res);
//    }
//
//    @Description("获取成果下载次数")
//    @RequestMapping(value = "/onlineUser", method = RequestMethod.GET)
//    public JSONResult getDownloadCount() {
//        Integer res = onlineDataService.getDownloadCount();
//        log.info("下载次数为"+ res +"..");
//        return JSONResult.ok("成功获取成果下载次数", res);
//    }
//
//    @Description("用户登录系统记录")
//    @RequestMapping("/logIn")
//    public JSONResult logInUser(@RequestParam("userId") Integer userId) {
//        Integer res = onlineDataService.insertLogInRecord(userId);
//        if(res >= 0){
//            return JSONResult.ok("用户登录成功", res);
//        }
//        else {
//            return JSONResult.error(3001, "用户登录记录失败!");
//        }
//
//    }
//
//    @Description("用户登出系统记录")
//    @RequestMapping("/logOut")
//    public JSONResult logOutUser(@RequestParam Integer userId) {
//        return onlineDataService.logOutUser(userId);
////        return JSONResult.ok("用户已登出!", res);
//    }

}