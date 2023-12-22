package com.alzartak.unilife.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCurriculumContainsAndOfferingCollegeContainsAndOfferingDepartmentContainsAndBaseCodeContainsAndCourseNameContainsAndLectureCategoryContains(String curriculum, String offeringCollege, String offeringDepartment, String BaseCode, String CourseName, String LectureCategory);
}
