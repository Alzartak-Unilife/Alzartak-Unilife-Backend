package com.alzartak.unilife.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByYearAndSemesterAndCurriculumContainsAndOfferingCollegeContainsAndOfferingDepartmentContainsAndBaseCodeContainsAndCourseNameContainsAndLectureCategoryContainsAndProfessorContainsAndLectureLanguageContains(int year, int semester, String curriculum, String offeringCollege, String offeringDepartment, String BaseCode, String CourseName, String LectureCategory, String professor, String lectureLanguage);
}
