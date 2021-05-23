package ro.fasttrackit.curs11.homework.client.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Document(collection = "CourseStudents")
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentEntity {
    @Id
    private String id;

    @NotNull
    private String courseId;

    @NotNull
    private String studentId;

    private Double grade;
}
