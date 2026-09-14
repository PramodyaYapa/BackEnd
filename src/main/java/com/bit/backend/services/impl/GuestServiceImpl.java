package com.bit.backend.services.impl;

import com.bit.backend.dtos.GuestDto;
import com.bit.backend.entities.GuestEntity;
import com.bit.backend.entities.StatusEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.GuestMapper;
import com.bit.backend.repositories.GuestRepository;
import com.bit.backend.repositories.StatusRepository;
import com.bit.backend.services.GuestServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestServiceI {

    private final GuestRepository guestRepository;
    private final StatusRepository statusRepository;
    private final GuestMapper guestMapper;

    public GuestServiceImpl(GuestRepository guestRepository,
                            StatusRepository statusRepository,
                            GuestMapper guestMapper ) {
        this.guestRepository = guestRepository;
        this.statusRepository = statusRepository;
        this.guestMapper = guestMapper;
    }

    @Override
    @Transactional
    public GuestDto addGuest(GuestDto guestDto) {
        StatusEntity status = resolveStatus(guestDto);
        GuestEntity entity = guestMapper.toGuestEntity(guestDto);
        entity.setId(null);
        entity.setStatus(status);

        GuestEntity saved = guestRepository.save(entity);
        if (saved.getGuest_code() == null || saved.getGuest_code().isBlank()) {
            saved.setGuest_code("STU-" + saved.getId());
            saved = guestRepository.save(saved);
        }
        return guestMapper.toGuestDto(saved);
    }

    @Override
    public List<GuestDto> getAllGuests() {
        return guestMapper.toGuestDtoList(guestRepository.findAll());
    }

    @Override
    public GuestDto getGuestById(long id) {
        GuestEntity entity = guestRepository.findById(id)
                .orElseThrow(() -> new AppException("guest not found", HttpStatus.NOT_FOUND));
        return guestMapper.toGuestDto(entity);
    }

    @Override
    @Transactional
    public GuestDto updateGuest(long id, GuestDto guestDto) {
        GuestEntity existing = guestRepository.findById(id)
                .orElseThrow(() -> new AppException("Guest not found", HttpStatus.NOT_FOUND));

        StatusEntity status = resolveStatus(guestDto);
        existing.setFirst_name(guestDto.getFirst_name());
        existing.setDate_of_birth(guestDto.getDate_of_birth());
        existing.setNic_passport(guestDto.getNic_passport());
        existing.setStatus(status);
        if (guestDto.getGuest_code() != null && !guestDto.getGuest_code().isBlank()) {
            existing.setGuest_code(guestDto.getGuest_code());
        }

        return guestMapper.toGuestDto(guestRepository.save(existing));
    }

    @Override
    @Transactional
    public GuestDto deleteGuest(long id) {
        GuestEntity existing = guestRepository.findById(id)
                .orElseThrow(() -> new AppException("Guest not found", HttpStatus.NOT_FOUND));
        GuestDto dto = guestMapper.toGuestDto(existing);
        guestRepository.delete(existing);
        return dto;
    }

    private StatusEntity resolveStatus(GuestDto guestDto) {
        if (guestDto.getStatus() == null || guestDto.getStatus().getId() == null) {
            throw new AppException("Status is required", HttpStatus.BAD_REQUEST);
        }
        return statusRepository.findById(guestDto.getStatus().getId())
                .orElseThrow(() -> new AppException("Status not found", HttpStatus.BAD_REQUEST));
    }
}