package ro.fasttrackit.curs11.homework.client.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs11.homework.client.model.entity.CourseStudentEntity;
import ro.fasttrackit.curs11.homework.client.model.entity.StudentCourseEntity;
import ro.fasttrackit.curs11.homework.client.service.CourseService;
import ro.fasttrackit.curs11.homework.client.service.CourseStudentService;
import ro.fasttrackit.curs11.homework.client.service.StudentCourseService;
import ro.fasttrackit.curs11.homework.client.service.StudentService;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CourseStudentService courseStudentService;
    private final StudentCourseService studentCourseService;
    private final CourseService courseService;
    private final StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        courseStudentService.addCourse(
                CourseStudentEntity.builder()
                        .courseId(courseService.getAll().get(0).getId())
                        .studentId(studentService.getAllStudents().get(0).getId())
                        .grade(8.5)
                        .build()
        );

        studentCourseService.addStudentCourse(
                StudentCourseEntity.builder()
                        .age(studentService.getAllStudents().get(0).getAge())
                        .grade(8.5)
                        .discipline(courseService.getAll().get(0).getDiscipline())
                        .build()
        );
    }
}
