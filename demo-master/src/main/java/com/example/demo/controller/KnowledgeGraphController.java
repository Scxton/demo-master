package com.example.demo.controller;

import com.example.demo.model.AchievementTable;
import com.example.demo.service.AchievementTableService;
import com.example.demo.utils.JSONResult;
import com.example.demo.utils.KnowledgeGraph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@RestController
public class KnowledgeGraphController {
    @Resource
    private AchievementTableService achievementTableService;
    /*
    * 获取所有知识图谱
    * @return JSONResult
    */
    @GetMapping("/knowledgegraph/getall")
    public JSONResult knowledgegraph(){
        log.info("knowledge start");
        List<AchievementTable> res = this.achievementTableService.queryAll();
        List<Object[]> knowList = KnowledgeGraph.getALL(res);
        JSONResult jsonResult = new JSONResult();
        log.info("knowledge graph all get list");
        if(knowList.size() > 0){
            jsonResult.setResultCode(200);
            jsonResult.setType("success");
            jsonResult.setData(knowList);
        }else{
            jsonResult.setResultCode(500);
            jsonResult.setType("error");
        }
        log.info("knowledge graph all end");
        return jsonResult;
    }
    /*
     * 根据筛选条件获取知识图谱
     * @param AchievementTable
     * @return JSONResult
     */
    @PostMapping("/knowledgegraph/getbylimit")
    public ResponseEntity<JSONResult> queryAllByLimit(@RequestBody AchievementTable achievementTable){
        log.info("knowledge graph limit start ");
        JSONResult jsonResult = new JSONResult();
        List<AchievementTable> res = this.achievementTableService.queryAllByLimit(achievementTable);
        log.info("knowledge graph limit get list");
        if(res.size() <= 0){
            jsonResult.setResultCode(500);
            jsonResult.setType("fail");
            jsonResult.setResultMsg("结果为空");
            }else{
            List<Object[]> knowList = KnowledgeGraph.getALL(res);
            if(knowList.size() > 0){
                jsonResult.setResultCode(200);
                jsonResult.setType("success");
                jsonResult.setData(knowList);
            }else{
                jsonResult.setResultCode(500);
                jsonResult.setType("fail");
            }
            }
        log.info("knowledge graph limit end");
        return ResponseEntity.ok(jsonResult);
    }
}