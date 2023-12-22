package com.alzartak.unilife.domain.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/search")
    public List<CourseResponse> searchCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.searchCourse(courseRequest);
    }
}
