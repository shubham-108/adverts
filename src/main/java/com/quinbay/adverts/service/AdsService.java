package com.quinbay.adverts.service;

import com.quinbay.adverts.dataModels.Ad;

import java.util.List;

public interface AdsService {
    Ad save(Ad ad);
    List<Ad> getByUsername(String username);
    List<Ad> getByCategory(String category);
}
