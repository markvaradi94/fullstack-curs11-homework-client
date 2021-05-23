package ro.fasttrackit.curs11.homework.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.homework.client.model.entity.CourseStudentEntity;

public interface CourseStudentEntityRepository extends MongoRepository<CourseStudentEntity, String> {
}
