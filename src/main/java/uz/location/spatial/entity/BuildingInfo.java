package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "building_info")
public class BuildingInfo implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "storey_count")
    private Integer storeyCount;

    @Column(name = "height")
    private Double height;

    @Column(name = "shape_length")
    private Double shapeLength;

    @Column(name = "shape_area")
    private Double shapeArea;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;
}
