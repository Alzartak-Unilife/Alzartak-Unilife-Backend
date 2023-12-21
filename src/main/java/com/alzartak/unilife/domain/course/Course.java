package com.alzartak.unilife.domain.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column
    private int year;

    @Column
    private int semester;

    @Column
    private String grades;

    @Column
    private String curriculum;

    @Column
    private String courseArea;

    @Column
    private String baseCode;

    @Column
    private String divCode;

    @Column
    private String courseName;

    @Column
    private String professor;

    @Column
    private String campus;

    @Column
    private String schedules;

    @Column
    private int credit;

    @Column
    private int theory;

    @Column
    private int practice;

    @Column
    private String lectureType;

    @Column
    private String lectureCategory;

    @Column
    private String lectureLanguage;

    @Column
    private String requirementType;

    @Column
    private String offeringCollege;

    @Column
    private String offeringDepartment;

    @Column
    private String remarks;
}
