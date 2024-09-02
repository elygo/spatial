package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.MultiPolygon;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "schools")
public class School implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;
    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(columnDefinition = "GEOMETRY(MultiPolygon,4326)")
    private MultiPolygon location;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location locationId;

    @ManyToOne
    @JoinColumn(name = "school_type_id")
    private SchoolType schoolType;

    @OneToMany(mappedBy = "school")
    private Set<SchoolLanguages> schoolLanguages;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    @OneToOne(mappedBy = "school")
    private Statistics statistics;
}