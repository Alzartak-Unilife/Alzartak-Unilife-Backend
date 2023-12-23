package com.alzartak.unilife.domain.course;

import com.alzartak.unilife.domain.avg.AvgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final AvgRepository avgRepository;

    public List<CourseResponse> searchCourse(CourseRequest courseRequest) {
        List<Course> courses = courseRepository.findByCurriculumContainsAndOfferingCollegeContainsAndOfferingDepartmentContainsAndBaseCodeContainsAndCourseNameContainsAndLectureCategoryContains(courseRequest.getCurriculum(), courseRequest.getOfferingCollege(), courseRequest.getOfferingDepartment(), courseRequest.getBaseCode(), courseRequest.getCourseName(), courseRequest.getLectureCategory());

        return courses.stream()
                .map(this::convertToCourseResponse)
                .collect(Collectors.toList());
    }

    public CourseResponse convertToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourseId(course.getCourseId());
        courseResponse.setYear(course.getYear());
        courseResponse.setSemester(course.getSemester());
        courseResponse.setCurriculum(course.getCurriculum());
        courseResponse.setCourseArea(course.getCourseArea());
        courseResponse.setBaseCode(course.getBaseCode());
        courseResponse.setDivCode(course.getDivCode());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setProfessor(course.getProfessor());
        courseResponse.setCampus(course.getCampus());
        courseResponse.setCredit(course.getCredit());
        courseResponse.setTheory(course.getTheory());
        courseResponse.setPractice(course.getPractice());
        courseResponse.setLectureType(course.getLectureType());
        courseResponse.setLectureCategory(course.getLectureCategory());
        courseResponse.setLectureLanguage(course.getLectureLanguage());
        courseResponse.setRequirementType(course.getRequirementType());
        courseResponse.setOfferingCollege(course.getOfferingCollege());
        courseResponse.setOfferingDepartment(course.getOfferingDepartment());
        courseResponse.setRemarks(course.getRemarks());

        courseResponse.setGrades(parseGrades(course.getGrades()));
        courseResponse.setSchedules(parseSchedules(course.getSchedules()));
        courseResponse.setAvgEvaluation(avgRepository.findAvgEvaluationByBaseCodeAndProfessor(course.getBaseCode(), course.getProfessor()));

        return courseResponse;
    }

    public List<Integer> parseGrades(String gradesStr) {
        gradesStr = gradesStr.trim().substring(1, gradesStr.length() - 1);

        return Arrays.stream(gradesStr.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Schedule> parseSchedules(String scheduleStr) {
        List<Schedule> schedules = new ArrayList<>();

        if (scheduleStr.equals("") || scheduleStr.equals("[]")) {
            return schedules;
        }

        Pattern pattern = Pattern.compile("\\{\"day\":\"(.*?)\",\"time\":\\{\"begin\":(\\d+),\"end\":(\\d+)\\},\"room\":\"(.*?)\"\\}");
        Matcher matcher = pattern.matcher(scheduleStr);

        while (matcher.find()) {
            LinkedHashMap<String, Integer> timeMap = new LinkedHashMap<>();

            Schedule schedule = new Schedule();
            schedule.setDay(matcher.group(1));
            timeMap.put("begin", Integer.parseInt(matcher.group(2)));
            timeMap.put("end", Integer.parseInt(matcher.group(3)));
            schedule.setTime(timeMap);
            schedule.setRoom(matcher.group(4));
            schedules.add(schedule);
        }

        return schedules;
    }
}
