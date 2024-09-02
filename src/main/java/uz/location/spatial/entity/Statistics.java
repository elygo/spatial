package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "statistics")
public class Statistics implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_students")
    private Integer numStudents;

    @Column(name = "num_teachers")
    private Integer numTeachers;

    @Column(name = "num_employees")
    private Integer numEmployees;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;
}