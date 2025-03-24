package com.example.demo.controller;

import com.example.demo.service.DataBackupService;
import com.example.demo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBackupController {

    @Autowired
    private DataBackupService dataBackupService;

    @GetMapping("/DataBackup")

    public ResponseEntity<JSONResult> triggerBackup() {
        dataBackupService.backupDatabase();
        //return "Backup triggered manually!";

        //AchievementTable res = this.achievementTableService.queryById(id);
        String msg = "Backup triggered manually!";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg, null);
        return ResponseEntity.ok(jsonResult);
    }
}
