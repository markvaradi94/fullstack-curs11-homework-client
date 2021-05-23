package ro.fasttrackit.curs11.homework.client.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs11.homework.client.model.entity.CourseStudentEntity;
import ro.fasttrackit.curs11.homework.client.model.filters.CourseStudentFilters;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class CourseStudentDao {
    private final MongoTemplate mongo;

    public List<CourseStudentEntity> findCourseStudents(CourseStudentFilters filters) {
        Query query = new Query();

        List<Criteria> criteria = new ArrayList<>();

        ofNullable(filters.getStudentId())
                .ifPresent(studentId -> criteria.add(Criteria.where("studentId").is(studentId)));

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        return mongo.find(query, CourseStudentEntity.class);
    }
}
