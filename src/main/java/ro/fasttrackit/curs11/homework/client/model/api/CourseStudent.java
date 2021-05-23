package ro.fasttrackit.curs11.homework.client.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {
    private String id;
    private String courseId;
    private String studentId;
    private Double grade;
}
