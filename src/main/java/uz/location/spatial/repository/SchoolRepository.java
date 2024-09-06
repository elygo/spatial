package uz.location.spatial.repository;

import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.location.spatial.entity.School;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE s.schoolName LIKE %:search%")
    Page<School> findAllWithSearch(Pageable pageable, @Param("search") String search);

    @Query(value = "SELECT * FROM schools s WHERE ST_DWithin(s.location, ST_Transform(ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326), 3857), :distance) ORDER BY ST_Distance(s.location, ST_Transform(ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326), 3857)) LIMIT 10", nativeQuery = true)
    List<School> getSchoolsWithinDistance(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("distance") double distance);
}