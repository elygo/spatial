package uz.location.spatial.service;

import java.util.List;

public interface BaseService<T, R, K> {
    List<R> readAll(Integer page, Integer size, String sortBy, String search);

    R readById(K id);

    R create(T createRequest);

    R update(T updateRequest);

    R patch(T updateRequest);

    void deleteById(K id);
}