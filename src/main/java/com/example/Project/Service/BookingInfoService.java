package com.example.Project.Service;

import com.example.Project.Entity.BookingInfo;


import java.util.List;

public interface BookingInfoService {

    List<BookingInfo> findInfoByEmail(String email);


}
