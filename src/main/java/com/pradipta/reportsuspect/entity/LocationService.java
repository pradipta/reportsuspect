package com.pradipta.reportsuspect.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public void saveLocation (Location location) {
        locationRepository.save(location);
    }
}
