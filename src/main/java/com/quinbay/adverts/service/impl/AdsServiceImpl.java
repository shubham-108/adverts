package com.quinbay.adverts.service.impl;

import com.quinbay.adverts.dataModels.Ad;
import com.quinbay.adverts.repository.AdsRepository;
import com.quinbay.adverts.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {
    @Autowired
    AdsRepository adsRepository;

    @Override
    public Ad save(Ad ad) {
        return adsRepository.save(ad);
    }

    @Override
    public List<Ad> getByUsername(String username) {
        return adsRepository.findByUsername(username);
    }

    @Override
    public List<Ad> getByCategory(String category) {

        List<Ad> adsForCategory = adsRepository.findByCategory(category);

        if(adsForCategory.size() == 0){
            return adsForCategory;
        }
        else {

            //TODO: POPULATE THE DATABASE WITH DEFAULT CATEGORY ADS

            return adsRepository.findByCategory("default");
        }



    }
}
