package com.banking.accounts.mapper;

import com.banking.accounts.dto.CustomerDto;
import com.banking.accounts.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDto);
}
