package com.example.demo.utils;

import com.example.demo.model.AchievementTable;

import java.util.ArrayList;
import java.util.List;


public class KnowledgeGraph {
    
    public static Object[] triplue(Object headEntity, Object relation, Object tailEntity){
        Object[] kg = new Object[]{};
        kg = new Object[]{headEntity, relation, tailEntity};
        return kg;
    }

    public static List<Object[]> getALL(List<AchievementTable> allinfo){
        List<Object[]> list = new ArrayList<Object[]>();

        for(AchievementTable at: allinfo){
            //知识图谱抽取规则
            Object[] trp1 = KnowledgeGraph.triplue(at.getAchievementName(), "所属类别", at.getAchievementCategory());
            list.add(trp1);
            Object[] trp2 = KnowledgeGraph.triplue(at.getAchievementName(), "归档形式", at.getAchievementForm());
            list.add(trp2);
            Object[] trp3 = KnowledgeGraph.triplue(at.getAchievementName(), "所属知识产权类型", at.getIntellectualPropertyId());
            list.add(trp3);
            Object[] trp4 = KnowledgeGraph.triplue(at.getAchievementBelongingOrganization(), "拥有", at.getProjectId());
            list.add(trp4);
            Object[] trp5 = KnowledgeGraph.triplue(at.getProjectId(), "包含", at.getAchievementName());
            list.add(trp5);
            Object[] trp6 = KnowledgeGraph.triplue(at.getUserId(), "创建", at.getAchievementName());
            list.add(trp6);
            }
        return list;
    }
}
