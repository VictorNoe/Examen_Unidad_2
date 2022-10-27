package mx.edu.utez.examenunitwo.model;

import mx.edu.utez.examenunitwo.utils.Response;

import javax.validation.constraints.Max;

public interface Repository<T> {
    Max.List<T> findAll();
    Response<T> save(T object);
}
