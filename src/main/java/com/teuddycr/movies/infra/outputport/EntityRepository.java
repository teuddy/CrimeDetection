package com.teuddycr.movies.infra.outputport;

import java.util.List;

//output port
public interface EntityRepository {

    public <T> T save(T reg);

    public <T> T getById(String id, Class<T> clazz);

    public <T> List<T> getAll(Class<T> clazz);

}