package ro.fasttrackit.curs11.homework.client.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourse {
    private String id;
    private Integer age;
    private String discipline;
    private Double grade;
}
