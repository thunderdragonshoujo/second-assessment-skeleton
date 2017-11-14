package com.cooksys.secondassessmentskeleton.mapper;

import org.mapstruct.Mapper;

import com.cooksys.secondassessmentskeleton.dto.TweetDto;
import com.cooksys.secondassessmentskeleton.pojo.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {

	TweetDto toDto(Tweet tweet);

	Tweet fromDto(TweetDto dto);

}
