package com.platform.pageable.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.pageable.dto.BaseDto;
import com.platform.pageable.resolver.PostPageable;
import com.platform.pageable.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Slf4j
public abstract class BaseController<T, ID extends Serializable> {

    protected String baseUri;
    protected BaseService service;

    @Autowired
    ObjectMapper mapper;

    protected BaseController(String baseUri, BaseService service) {
        this.baseUri = baseUri;
        this.service = service;
    }

    @GetMapping
    public BaseDto readAll() {
        List list = service.readAll();
        return new BaseDto(list.size(), list);
    }
    @PostMapping("pageable")
    public Page<T> readPage(@PostPageable  Pageable pageable) {
        return service.search(pageable);
    }

    @PostMapping
    public T create(@RequestBody T dto) {
        return (T)service.create(dto);
    }

    @GetMapping("/{id}")
    public T read(@PathVariable ID id) {
        return (T)service.read(id);
    }

    @PatchMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T dto) {
        return (T) service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
