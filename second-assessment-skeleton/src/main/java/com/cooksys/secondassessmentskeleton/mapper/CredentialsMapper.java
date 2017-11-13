package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.CredentialsDto;
import com.cooksys.secondassessmentskeleton.pojo.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
	CredentialsDto toDto(Credentials credentials);

	Credentials fromDto(CredentialsDto dto);

}
