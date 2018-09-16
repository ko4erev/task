package com.example.task.service;

import com.example.task.controller.data.SaveObject;

import java.util.Optional;

public interface MainService<T> {


    /**
     * @param id
     * @return вовзращает список запрашиваемых обьектов <T>
     */
    Optional<T> findById(Long id);

    /**
     * @param request обьект который нужно сохранить
     * @return вовзращает сохраненный обьект
     */

    T save(SaveObject request);

    /**
     * * Удаляет обьект по id
     *
     * @param id
     */
    void delete(Long id);
}
