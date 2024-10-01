package com.example.Project.Repository;

import com.example.Project.Entity.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {

    List<BookingInfo> findByEmail(String email);
}
