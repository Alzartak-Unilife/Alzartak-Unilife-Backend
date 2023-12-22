package com.alzartak.unilife.domain.course;

import lombok.Data;

import java.util.List;

@Data
public class CourseResponse {
    private Long courseId;

    private int year;

    private int semester;

    private List<Integer> grades;

    private String curriculum;

    private String courseArea;

    private String baseCode;

    private String divCode;

    private String courseName;

    private String professor;

    private String campus;

    private List<Schedule> schedules;

    private int credit;

    private int theory;

    private int practice;

    private String lectureType;

    private String lectureCategory;

    private String lectureLanguage;

    private String requirementType;

    private String offeringCollege;

    private String offeringDepartment;

    private String remarks;
}