package ro.fasttrackit.curs11.homework.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs11.homework.client.model.api.Course;
import ro.fasttrackit.curs11.homework.client.service.CourseStudentService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseStudentService service;

    @GetMapping
    List<Course> getAllCourse() {
        return service.findAllCourses();
    }

    @GetMapping("{courseId}")
    Course findById(@PathVariable String courseId) {
        return service.findCourseById(courseId);
    }
}
