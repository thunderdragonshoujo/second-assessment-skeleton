package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.HashtagDto;
import com.cooksys.secondassessmentskeleton.pojo.Hashtag;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
	HashtagDto toDto(Hashtag hashtag);

	Hashtag fromDto(HashtagDto dto);

}
