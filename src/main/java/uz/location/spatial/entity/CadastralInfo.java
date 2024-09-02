package uz.location.spatial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cadastral_info")
public class CadastralInfo implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cadastral;
    private String cadnum;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;
}