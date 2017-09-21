package com.citting.converters;
import com.citting.dao.CategoryDao;
import com.citting.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {


    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Category convert(String source) {
        Category category = categoryDao.findById(Integer.parseInt(source));
        return  category;
    }
}

