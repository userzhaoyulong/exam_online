package com.yulong.pojo;

/**
 * @program: exam_online
 * @description: 年级分类
 * @author: Dragon
 * @create: 2019-07-07 18:19
 */
public class Grade {
    private Integer gradeid;
    private String gradename;
    private String courseid;

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }
}
