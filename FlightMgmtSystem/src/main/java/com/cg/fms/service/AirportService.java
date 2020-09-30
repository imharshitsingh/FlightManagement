package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.dao.AirportDao;
import com.cg.fms.entity.Airport;



@Service
public class AirportService {
	@Autowired
	private AirportDao airportDao;
	
	@Transactional
	public boolean addAirport(Airport airport) 
	{
		return airportDao.save(airport) != null;
	}
	
	@Transactional
	public void deleteAirport(String airportCode) 
	{
		airportDao.deleteById(airportCode);
	}
	
	@Transactional
	public List<Airport> viewAllAirport()
	{
		return airportDao.findAll();
	}
	
	@Transactional
	public boolean updateAirport(Airport airport, String airportCode)
	{
		airport.setAirportLocation(airport.getAirportLocation()) ;
		return airportDao.save(airport) !=null;
	}
	
	@Transactional
	public Optional<Airport> airportInfo(String airportCode){
		return airportDao.findById(airportCode);
	}

}
