package com.cg.fms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dao.AirportDao;
import com.cg.fms.entity.Airport;
import com.cg.fms.exception.AirportException;
import com.cg.fms.service.AirportService;

@RestController
public class AirportController {
    @Autowired
	private AirportService airportService;
    @Autowired
    private AirportDao airportDao;
    
    @CrossOrigin
    @PostMapping("/addairport")
    public ResponseEntity<String> addAirport(@Valid @RequestBody Airport airport, BindingResult br) 
    		throws AirportException 
    {
		
		  if(airportDao.existsById(airport.getAirportCode())) { throw new AirportException("Airport Already Exists");
		 
		 }
		    airportService.addAirport(airport);
			return new ResponseEntity<String>("Airport added successfully", HttpStatus.OK);		
    }
	
    @CrossOrigin
    @GetMapping("/viewallairport")
    public ResponseEntity<List<Airport>> getAirportList()
    {
    	List<Airport> airportList= airportService.viewAllAirport();
    	return new ResponseEntity<List<Airport>>(airportList,HttpStatus.OK);
    }
    
    @CrossOrigin
    @DeleteMapping("/deleteairport/{airportCode}")
    public ResponseEntity<String> deleteAirport(@PathVariable String airportCode) throws AirportException
    {
    	if(!(airportDao.existsById(airportCode))) {
    		throw new AirportException("Airport does not exists");
    	}
    	try {
    		airportService.deleteAirport(airportCode);
    		return new ResponseEntity<String> ("Airport deleted successfully", HttpStatus.OK);
    	}
    	catch(Exception e) {
    		throw new AirportException(e.getMessage());
    	}
    }
    
    @CrossOrigin
    @GetMapping("/airportdetails/{airportCode}")
    public Optional<Airport> airportDetails(@PathVariable String airportCode) throws AirportException{
    	if(!(airportDao.existsById(airportCode))) {
    		throw new AirportException("Airport does not exists");
    	}
    	
    	try {
    		return airportService.airportInfo(airportCode);
    	}
    	catch(Exception e) {
    		throw new AirportException("Airport does not exist");
    	}
    }
    
	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping("/updateairport/{airportCode}") public ResponseEntity <String>
	 * updateAirport(@Valid @RequestBody Airport airport, @PathVariable String
	 * airportCode, BindingResult br) throws AirportException{
	 * 
	 * try { airportService.updateAirport(airport, airportCode); return new
	 * ResponseEntity<String>("Airport updated successfully", HttpStatus.OK); }
	 * catch(Exception e) { throw new AirportException(e.getMessage()); } }
	 */

}
