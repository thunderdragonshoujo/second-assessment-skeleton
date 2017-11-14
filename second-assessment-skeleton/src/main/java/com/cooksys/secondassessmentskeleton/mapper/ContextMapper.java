package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.ContextDto;
import com.cooksys.secondassessmentskeleton.pojo.Context;

@Mapper(componentModel = "spring")
public interface ContextMapper {
	ContextDto toDto(Context context);

	Context fromDto(ContextDto dto);

}
