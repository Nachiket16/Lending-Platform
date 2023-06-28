package com.mintifi.postgres.mapper;

import com.mintifi.postgres.entity.Company;
import com.mintifi.postgres.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy =
    NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper {
  @Mapping(target = "id", ignore = true)
  Company updateEntityFromModel(CompanyModel model, @MappingTarget Company entity);

}
