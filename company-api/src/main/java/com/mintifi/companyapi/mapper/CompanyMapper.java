package com.mintifi.companyapi.mapper;

import com.mintifi.companyapi.entity.Company;
import com.mintifi.companyapi.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy =
    NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper {

  @Mapping(target = "id", ignore = true)
  Company companyApiToEntity(CompanyModel companyModel);

  @Mapping(target = "id", ignore = true)
  Company updateEntityFromModel(CompanyModel model, @MappingTarget Company entity);

}

