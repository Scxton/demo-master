package com.example.demo.utils;
import java.util.logging.Logger;
import com.example.demo.model.AchievementTable;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
public class KnowledgeGraph {
    private static final Logger logger = Logger.getLogger(KnowledgeGraph.class.getName());

    public static Object[] triplue(Object headEntity, Object relation, Object tailEntity){
        Object[] kg = new Object[]{};
        kg = new Object[]{headEntity, relation, tailEntity};
//        String tripleStr = String.format("三元组: [%s] --(%s)--> [%s]",
//                headEntity != null ? headEntity : "null",
//                relation != null ? relation : "null",
//                tailEntity != null ? tailEntity : "null");
//        logger.info(tripleStr);

        return kg;
    }

    public static List<Object[]> getALL(List<AchievementTable> allinfo){
        Map<String, Integer> relationCounts = new HashMap<>();
        List<Object[]> list = new ArrayList<Object[]>();
        log.info("111111111111111111111111111111");

        for(AchievementTable at: allinfo){
            //知识图谱抽取规则
//            Object[] trp1 = KnowledgeGraph.triplue(at.getAchievementName(), "所属类别", at.getAchievementCategory());
//            list.add(trp1);
//            Object[] trp2 = KnowledgeGraph.triplue(at.getAchievementName(), "归档形式", at.getAchievementForm());
//            list.add(trp2);
//            Object[] trp3 = KnowledgeGraph.triplue(at.getAchievementName(), "所属知识产权类型", at.getIntellectualPropertyId());
//            list.add(trp3);
//            Object[] trp4 = KnowledgeGraph.triplue(at.getAchievementBelongingOrganization(), "拥有", at.getProjectId());
//            list.add(trp4);
//            Object[] trp5 = KnowledgeGraph.triplue(at.getProjectId(), "包含", at.getAchievementName());
//            list.add(trp5);
//            Object[] trp6 = KnowledgeGraph.triplue(at.getUserId(), "创建", at.getAchievementName());
//            list.add(trp6);
            Object[] trp1 = KnowledgeGraph.triplue(at.getAchievementName(), "所属类别", at.getAchievementCategory());
            list.add(trp1);
            Object[] trp2 = KnowledgeGraph.triplue(at.getAchievementName(), "技术分类", at.getTechnologyCategory());
            list.add(trp2);
            Object[] trp3 = KnowledgeGraph.triplue(at.getAchievementName(), "学科分类", at.getSubjectCategory());
            list.add(trp3);
            Object[] trp4 = KnowledgeGraph.triplue(at.getOrganizationName(), "组织连接", at.getAchievementName());
            list.add(trp4);
            Object[] trp5 = KnowledgeGraph.triplue(at.getProjectId(), "项目连接", at.getAchievementName());
            list.add(trp5);
            Object[] trp6 = KnowledgeGraph.triplue(at.getUserId(), "作者连接", at.getAchievementName());
            list.add(trp6);
            }
        return list;
    }
}
