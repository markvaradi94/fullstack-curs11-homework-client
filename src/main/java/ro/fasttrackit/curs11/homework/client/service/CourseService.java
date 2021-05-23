package ro.fasttrackit.curs11.homework.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.curs11.homework.client.model.api.Course;

import java.util.List;

@Service
public class CourseService {
    private static final String COURSES_URL = "http://localhost:8082/courses";

    public Course findById(String courseId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(COURSES_URL + "/" + courseId, Course.class);
    }

    public List<Course> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                COURSES_URL,
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Course>>() {
                }
        ).getBody();
    }
}
