package com.korea.calendar.domain.user.repository;

import com.korea.calendar.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Integer> {

    Optional<SiteUser> findByUsername(String username);
}