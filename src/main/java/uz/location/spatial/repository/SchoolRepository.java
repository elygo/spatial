package uz.location.spatial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.location.spatial.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE s.schoolName LIKE %:search%")
    Page<School> findAllWithSearch(Pageable pageable, @Param("search") String search);
}