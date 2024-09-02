package uz.location.spatial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String language;
    private String region;
    private String city;
    private Integer numStudents;
}