package ro.fasttrackit.curs11.homework.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.homework.client.model.entity.StudentCourseEntity;
import ro.fasttrackit.curs11.homework.client.repository.StudentCourseRepository;

import java.util.List;

import static java.util.Collections.unmodifiableList;

@Service
@RequiredArgsConstructor
public class StudentCourseService {
    private final StudentCourseRepository repository;
    private final StudentService studentService;
    private final CourseService courseService;

    public List<StudentCourseEntity> getAll() {
        return unmodifiableList(repository.findAll());
    }

    public StudentCourseEntity addStudentCourse(StudentCourseEntity studentCourseEntity) {
        return repository.save(studentCourseEntity);
    }
}
