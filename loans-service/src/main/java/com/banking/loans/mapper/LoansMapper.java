package com.banking.loans.mapper;

import com.banking.loans.dto.LoansDto;
import com.banking.loans.model.Loans;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LoansMapper {

    LoansDto toDto(Loans loans);

    Loans toEntity(LoansDto loansDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLoanFromDto(LoansDto loansDto, @MappingTarget Loans loans);

}