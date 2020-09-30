package com.cg.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.fms.entity.Airport;
import com.cg.fms.dao.AirportDao;

@SpringBootApplication
public class FlightMgmtSystemApplication implements CommandLineRunner {
	@Autowired
	private AirportDao airportDao;
	

	public static void main(String[] args) {
		SpringApplication.run(FlightMgmtSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Airport air = new Airport("D80","Delhi","Delhi"); Airport air1 = new
		 * Airport("H90","Hyedrabad","Ragiv international"); airportDao.save(air);
		 * airportDao.save(air1); System.out.println("record inserted");
		 */
		
	}

}
