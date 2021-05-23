package ro.fasttrackit.curs11.homework.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.fasttrackit.curs11.homework.client.model.api.Student;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class StudentService {
    private static final String STUDENTS_URL = "http://localhost:8081/students";

    public List<Student> getAllStudents() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                STUDENTS_URL,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Student>>() {
                }
        ).getBody();
    }

    public List<Student> getStudentsByAge(Integer age) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STUDENTS_URL)
                .queryParam("age", age);

        return restTemplate.exchange(
                builder.toUriString(),
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Student>>() {
                }
        ).getBody();
    }

    public Student findById(String studentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(STUDENTS_URL + "/" + studentId, Student.class);
    }
}
