package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.pojo.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(Users users);
	
	Users fromDto(UserDto dto);

}
