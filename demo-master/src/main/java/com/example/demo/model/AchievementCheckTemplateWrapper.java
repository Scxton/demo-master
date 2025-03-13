package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AchievementCheckTemplateWrapper {
    // Getters and Setters
    @JsonUnwrapped
    private AchievementCheckTemplate template;
    private String userName;

    public AchievementCheckTemplateWrapper(AchievementCheckTemplate template, String userName) {
        this.template = template;
        this.userName = userName;
    }

}
