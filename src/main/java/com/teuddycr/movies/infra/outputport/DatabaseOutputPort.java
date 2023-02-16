package com.teuddycr.movies.infra.outputport;

import java.util.List;

// This is the Data base output Port / mi cortafuego de mi base de datos
public interface DatabaseOutputPort {

    public <T> T save(T reg);

    public <T> T getById(String id, Class<T> clazz);

    public <T> List<T> getAll(Class<T> clazz);

}