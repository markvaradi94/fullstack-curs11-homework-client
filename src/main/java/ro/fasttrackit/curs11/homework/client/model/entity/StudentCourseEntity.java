package ro.fasttrackit.curs11.homework.client.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "StudentCourses")
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseEntity {
    @Id
    private String id;

    private Integer age;

    private String discipline;

    private Double grade;
}
