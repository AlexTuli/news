package com.epam.alex.dao;

import com.epam.alex.model.News;

import java.util.List;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public interface NewsDao {

    List<News> readAll();

    News readById(News news);

    void save (News news);

    void delete (News news);

}
