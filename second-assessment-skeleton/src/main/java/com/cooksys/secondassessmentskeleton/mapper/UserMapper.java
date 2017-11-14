package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.pojo.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User user);
	
	User fromDto(UserDto dto);

}
