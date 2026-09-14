package com.bit.backend.controllers;

import com.bit.backend.dtos.ApiListResponse;
import com.bit.backend.dtos.GuestDto;
import com.bit.backend.dtos.StatusDto;
import com.bit.backend.services.GuestServiceI;
import com.bit.backend.services.StatusServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GuestController {

    private final GuestServiceI guestServiceI;
    private final StatusServiceI statusServiceI;

    public GuestController(GuestServiceI guestServiceI, StatusServiceI statusServiceI) {
        this.guestServiceI = guestServiceI;
        this.statusServiceI = statusServiceI;
    }


//    @GetMapping("/status")
//    public ResponseEntity<ApiListResponse<StatusDto>> getAllStatus() {
//        return ResponseEntity.ok(ApiListResponse.of(statusServiceI.getAllStatus()));
//    }

    @GetMapping("/guest")
    public ResponseEntity<ApiListResponse<GuestDto>> getAllGuest() {
        return ResponseEntity.ok(ApiListResponse.of(guestServiceI.getAllGuests()));
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<ApiListResponse<GuestDto>> getGuestsById(@PathVariable long id) {
        return ResponseEntity.ok(ApiListResponse.ofOne(guestServiceI.getGuestById(id)));
    }

    @PostMapping("/guest")
    public ResponseEntity<ApiListResponse<GuestDto>> addGuest(@RequestBody GuestDto guestDto) {
        GuestDto created = guestServiceI.addGuest(guestDto);
        return ResponseEntity.created(URI.create("/api/v1/guest/" + created.getId()))
                .body(ApiListResponse.ofOne(created));
    }

    @PutMapping("/guest/{id}")
    public ResponseEntity<ApiListResponse<GuestDto>> updateGuest(
            @PathVariable long id,
            @RequestBody GuestDto guestDto) {
        return ResponseEntity.ok(ApiListResponse.ofOne(guestServiceI.updateGuest(id, guestDto)));
    }

    @DeleteMapping("/guest/{id}")
    public ResponseEntity<ApiListResponse<GuestDto>> deleteGuest(@PathVariable long id) {
        return ResponseEntity.ok(ApiListResponse.ofOne(guestServiceI.deleteGuest(id)));
    }

    @GetMapping("/guest/getGuest/{guestId}")
    public ResponseEntity<ApiListResponse<Map<String, Object>>> getGuestsForClass(@PathVariable long courseId) {
        List<Map<String, Object>> empty = Collections.emptyList();
        return ResponseEntity.ok(ApiListResponse.of(empty));
    }
}
