package com.phexum.formelite.infralayer.common;

import org.modelmapper.ModelMapper;

public class Convertible<I, R> {

    private final ModelMapper mapper;
    private Class<I> model;
    private Class<R> entity;


    public Convertible(ModelMapper mapper, Class<I> model, Class<R> entity) {
        this.mapper = mapper;
        this.model = model;
        this.entity = entity;
    }

    protected R modelToEntity(I source) {
        return mapper.map(source, entity);
    }

    protected I entityToModel(R source) {

        return mapper.map(source, model);
    }

    protected <T, P> P independentMapper(T source, Class<P> destination) {

        return mapper.map(source, destination);
    }

}