package com.bit.backend.services;

import com.bit.backend.dtos.GuestDto;

import java.util.List;

public interface GuestServiceI {
    GuestDto addGuest( GuestDto guestDto);
    List<GuestDto> getAllGuests();
    GuestDto getGuestById(long id);
    GuestDto updateGuest(long id, GuestDto guestDto);
    GuestDto deleteGuest(long id);
}
