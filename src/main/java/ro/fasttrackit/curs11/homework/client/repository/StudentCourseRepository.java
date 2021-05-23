package ro.fasttrackit.curs11.homework.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.homework.client.model.entity.StudentCourseEntity;

public interface StudentCourseRepository extends MongoRepository<StudentCourseEntity, String> {
}
