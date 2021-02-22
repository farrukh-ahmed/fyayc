package com.fyayc.Interview.mapping;

import com.fyayc.Interview.dto.ProductDto;
import com.fyayc.Interview.dto.UserDto;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.entities.UserEntity;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring"
        //, uses = {ProductMapper.class}
        )
public interface UserMapper {

    @InheritInverseConfiguration
    UserDto toUserDto(UserEntity user, @Context MappingContext context);

    //@Mapping(source = "products",target = "products")
    UserEntity userDtoToUser(UserDto userDto, @Context MappingContext context);

    List<UserDto> toUserDtos(List<UserEntity> users);

    @InheritInverseConfiguration
    ProductDto toProductDto(ProductEntity product, @Context MappingContext context);


   // @Mapping(target = "users",ignore = true)
    ProductEntity toProduct(ProductDto productDto,  @Context MappingContext context);

    List<ProductDto> toProductDtos(List<ProductEntity> products);


}
