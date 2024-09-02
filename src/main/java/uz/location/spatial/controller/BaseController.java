package uz.location.spatial.controller;

import java.util.List;

public interface BaseController<T, R, K> {

    List<R> readAll(Integer page, Integer size, String sortBy, String search);

    R readById(K id);

    R create(T createRequest);

    R update(K id, T updateRequest);

    R patch(K id, T updateRequest);

    void deleteById(K id);
}
