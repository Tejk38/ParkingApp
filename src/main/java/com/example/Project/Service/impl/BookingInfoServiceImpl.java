package com.example.Project.Service.impl;

import com.example.Project.Entity.BookingInfo;
import com.example.Project.Entity.User;
import com.example.Project.Repository.BookingInfoRepository;
import com.example.Project.Service.BookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingInfoServiceImpl implements BookingInfoService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    @Override
    public List<BookingInfo> findInfoByEmail(String email) {
        return bookingInfoRepository.findByEmail(email);
    }
}
