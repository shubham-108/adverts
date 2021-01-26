package com.quinbay.adverts.repository;

import com.quinbay.adverts.dataModels.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends CrudRepository<Ad, Long> {
    List<Ad> findByUsername(String username);
    List<Ad> findByCategory(String category);
}
