package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "infrastructure")
public class Infrastructure implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_type")
    private String facilityType;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;
}