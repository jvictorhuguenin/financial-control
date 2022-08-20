package com.finantialcontrol.mapper;

import com.finantialcontrol.dtos.UserAllPostDto;
import com.finantialcontrol.dtos.UserGetDto;
import com.finantialcontrol.dtos.UserRegistrationDto;
import com.finantialcontrol.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

  // UserGetDto mappings
  User userGetDtoToUser(UserGetDto userGetDto);

  UserGetDto userToUserGetDto(User user);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  User updateUserFromUserGetDto(
      UserGetDto userGetDto, @MappingTarget User user);

  // UserPostDto mappings
  @Mapping(source = "password", target = "hash")
  User userPostDtoToUser(UserRegistrationDto userRegistrationDto);

  @Mapping(source = "hash", target = "password")
  UserRegistrationDto userToUserPostDto(User user);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(source = "password", target = "hash")
  User updateUserFromUserPostDto(
      UserRegistrationDto userRegistrationDto, @MappingTarget User user);

  // UserAllPostDto mappings
  @Mapping(source = "password", target = "hash")
  User userAllPostDtoToUser(UserAllPostDto userAllPostDto);

  @Mapping(source = "hash", target = "password")
  UserAllPostDto userToUserAllPostDto(User user);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(source = "password", target = "hash")
  User updateUserFromUserAllPostDto(
      UserAllPostDto userAllPostDto, @MappingTarget User user);
}
