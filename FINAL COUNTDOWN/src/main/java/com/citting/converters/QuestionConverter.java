package com.citting.converters;

import com.citting.dao.QuestionDao;
import com.citting.entity.Question;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionConverter implements Converter<String, Question> {

    @Autowired
    private QuestionDao questionDao;
    @Override
    public Question convert(String source) {
            Question question = questionDao.findById(Integer.parseInt(source));
            return  question;
            }
    }
