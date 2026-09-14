package com.bit.backend.repositories;

import com.bit.backend.entities.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
}
