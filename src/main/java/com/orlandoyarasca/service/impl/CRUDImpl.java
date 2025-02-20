package com.orlandoyarasca.service.impl;


import com.orlandoyarasca.exception.ModelNotFoundException;
import com.orlandoyarasca.repository.IGenericRepo;
import com.orlandoyarasca.service.ICrudService;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICrudService<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        //VALIDAR ID
        //t.setIdCategory(id);
        //t.setIdClient(id);
        //JAVA API REFLECTION
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        //setIdXYZ
        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName,id.getClass());
        setIdMethod.invoke(t,id);
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
