package com.quinbay.adverts.controller;


import com.quinbay.adverts.dataModels.Ad;
import com.quinbay.adverts.dataModels.StandardResponse;
import com.quinbay.adverts.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ad")
public class AdsController {

    @Autowired
    AdsService adsService;

    @GetMapping(value = "/getadsbyusername/{username}")
    StandardResponse getAdsByUsername(@PathVariable("username") String username) {
        Map<String, Object> data = new HashMap<>();

        try {

            List<Ad> ads = adsService.getByUsername(username);

            if (ads.size() < 1) {
                throw new Exception("User does not have any ads");
            } else {
                data.put("ads", ads);
                return new StandardResponse(true, "", data);
            }


        } catch (Exception e) {

            return new StandardResponse(false, e.getMessage(), data);

        }


    }


    @GetMapping(value = "getadsforuser/{username}")
    StandardResponse getAdsForUsername(@PathVariable("username") String username) {
        Map<String, Object> data = new HashMap<>();

        String category = "default";

        try {

            // Make an api call to data analytics api to fetch users favorite category

            // user .sublist method to send fewer ads
            data.put("ads", adsService.getByCategory(category));

            return new StandardResponse(true, "", data);
        } catch (Exception e) {

            return new StandardResponse(false, "NO ADS FOUND", data);
        }

    }

    @GetMapping(value = "/getadsbycategory/{category}")
    StandardResponse getAdsByCategory(@PathVariable("category") String category) {
        Map<String, Object> data = new HashMap<>();
        data.put("ads", adsService.getByCategory(category));

        return new StandardResponse(true, "", data);
    }

    @PostMapping(value = "/addadvert")
    StandardResponse saveActivity(@RequestBody Ad ad) {
        adsService.save(ad);
        return new StandardResponse(true, "", new HashMap<String, Object>());
    }

}
