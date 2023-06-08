package com.manager.app.mapper;

import com.manager.app.model.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface UserMapper {
//    https://www.baeldung.com/spring-data-partial-update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFrom(User user, @MappingTarget User entity);
}