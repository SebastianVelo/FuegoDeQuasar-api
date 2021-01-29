package com.fuegodequasar.repository;

import java.io.Serializable;

import com.fuegodequasar.entity.Satellite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Serializable> {
    
    public abstract Satellite findByName(String name);
}
