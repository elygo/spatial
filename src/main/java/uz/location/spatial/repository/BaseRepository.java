package uz.location.spatial.repository;

import uz.location.spatial.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<K>, K> {

    List<T> readAll(Integer page, Integer size, String sortBy, String search);

    Optional<T> readById(K id);

    T create(T entity);

    T update(T entity);

    void deleteById(K id);

    boolean existById(K id);
}
