package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.ProfileDto;
import com.cooksys.secondassessmentskeleton.pojo.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
	ProfileDto toDto(Profile user);

	Profile fromDto(ProfileDto dto);

}
