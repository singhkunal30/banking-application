package com.banking.cards.mapper;

import com.banking.cards.dto.CardsDto;
import com.banking.cards.model.Cards;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CardsMapper {

    CardsDto toDto(Cards cards);

    Cards toEntity(CardsDto cardsDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCardFromDto(CardsDto cardsDto, @MappingTarget Cards cards);

}