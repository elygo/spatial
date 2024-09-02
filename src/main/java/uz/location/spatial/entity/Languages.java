package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "languages")
public class Languages implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_name", nullable = false, unique = true)
    private String languageName;

    @OneToMany(mappedBy = "language")
    private Set<SchoolLanguages> schoolLanguages;
}