package com.alzartak.unilife.domain.course;

import lombok.Data;

@Data
public class CourseRequest {
    private int year;

    private int semester;

    private String curriculum;

    private String offeringCollege;

    private String offeringDepartment;

    private String baseCode;

    private String courseName;

    private String lectureCategory;

    private String professor;

    private String lectureLanguage;
}
