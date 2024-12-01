package com.kienthong.fashion.services;

import com.kienthong.fashion.models.User;

public interface IUserService {
    User findByUsername(String userName);
}
