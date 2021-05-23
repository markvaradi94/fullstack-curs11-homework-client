package ro.fasttrackit.curs11.homework.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.homework.client.model.api.Course;
import ro.fasttrackit.curs11.homework.client.model.api.Student;
import ro.fasttrackit.curs11.homework.client.model.entity.CourseStudentEntity;
import ro.fasttrackit.curs11.homework.client.model.filters.CourseStudentFilters;
import ro.fasttrackit.curs11.homework.client.repository.CourseStudentDao;
import ro.fasttrackit.curs11.homework.client.repository.CourseStudentEntityRepository;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentEntityRepository repository;
    private final CourseStudentDao dao;
    private final CourseService courseService;
    private final StudentService studentService;

    public List<CourseStudentEntity> findAll(CourseStudentFilters filters) {
        return unmodifiableList(dao.findCourseStudents(filters));
    }

    public List<Course> findAllCourses() {
        return courseService.getAll();
    }

    public CourseStudentEntity addCourse(CourseStudentEntity courseStudentEntity) {
        return repository.save(courseStudentEntity);
    }

    public Course findCourseById(String courseId) {
        return courseService.findById(courseId);
    }

    public List<Course> findCoursesForStudent(String studentId) {
        List<String> studentCourseIds = courseIDsForStudent(studentId);
        return studentCourseIds.stream()
                .map(this::getCourseById)
                .collect(toUnmodifiableList());
    }

    public List<Student> findStudentsForCourse(String courseID) {
        List<String> courseStudentIds = studentIDsForCourse(courseID);
        return courseStudentIds.stream()
                .map(this::getStudentById)
                .collect(toUnmodifiableList());
    }

    private List<String> courseIDsForStudent(String studentId) {
        return repository.findAll().stream()
                .filter(courseStudent -> courseStudent.getStudentId().equalsIgnoreCase(studentId))
                .map(CourseStudentEntity::getCourseId)
                .collect(toUnmodifiableList());
    }

    private List<String> studentIDsForCourse(String courseId) {
        return repository.findAll().stream()
                .filter(courseStudent -> courseStudent.getCourseId().equalsIgnoreCase(courseId))
                .map(CourseStudentEntity::getStudentId)
                .collect(toUnmodifiableList());
    }

    private Course getCourseById(String courseId) {
        return courseService.findById(courseId);
    }

    private Student getStudentById(String studentId) {
        return studentService.findById(studentId);
    }
}
