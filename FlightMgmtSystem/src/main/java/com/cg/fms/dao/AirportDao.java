package com.cg.fms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {

}
