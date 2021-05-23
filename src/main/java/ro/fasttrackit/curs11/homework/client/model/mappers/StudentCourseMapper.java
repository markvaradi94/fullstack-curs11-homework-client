package ro.fasttrackit.curs11.homework.client.model.mappers;

import ro.fasttrackit.curs11.homework.client.model.api.StudentCourse;
import ro.fasttrackit.curs11.homework.client.model.entity.StudentCourseEntity;

public class StudentCourseMapper implements Mapper<StudentCourse, StudentCourseEntity> {
    @Override
    public StudentCourse toApi(StudentCourseEntity source) {
        if (source == null) {
            return null;
        }

        var target = new StudentCourse();
        target.setId(source.getId());
        target.setAge(source.getAge());
        target.setDiscipline(source.getDiscipline());
        target.setGrade(source.getGrade());

        return target;
    }

    @Override
    public StudentCourseEntity toEntity(StudentCourse source) {
        if (source == null) {
            return null;
        }

        var target = new StudentCourseEntity();
        target.setId(source.getId());
        target.setAge(source.getAge());
        target.setDiscipline(source.getDiscipline());
        target.setGrade(source.getGrade());

        return target;
    }
}
