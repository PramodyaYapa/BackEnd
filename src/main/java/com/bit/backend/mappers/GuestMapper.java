package com.bit.backend.mappers;

import com.bit.backend.dtos.GuestDto;
import com.bit.backend.dtos.StatusDto;
import com.bit.backend.entities.GuestEntity;
import com.bit.backend.entities.StatusEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface GuestMapper {

    StatusDto toStatusDto(StatusEntity entity);

    List<StatusDto> toStatusDtoList(List<StatusEntity> entities);

    @Mapping(target = "status", source = "status")
    GuestDto toGuestDto(GuestEntity entity);

    List<GuestDto> toGuestDtoList(List<GuestEntity> entities);

    @Mapping(target = "status", ignore = true)
    GuestEntity toGuestEntity(GuestDto dto);
}
