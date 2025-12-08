package com.banking.accounts.mapper;

import com.banking.accounts.dto.AccountDto;
import com.banking.accounts.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);

}