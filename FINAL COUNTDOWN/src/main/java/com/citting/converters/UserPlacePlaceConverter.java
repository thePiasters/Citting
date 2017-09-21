package com.citting.converters;
import com.citting.entity.Place;
import com.citting.entity.UserPlace;

import org.springframework.core.convert.converter.Converter;

public class UserPlacePlaceConverter implements Converter<UserPlace, Place> {

    @Override
    public Place convert(UserPlace source) {

        return  source.getPlace();
    }
}