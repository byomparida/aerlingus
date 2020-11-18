package com.aerlingus.flight.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerlingus.flight.model.FlightInfoDetail;
import com.aerlingus.flight.service.FlightInfoService;

@RestController
@RequestMapping("/{version:v[1-9]|v[0-9]{2,}}/flight")
public class FlightInfoController {

	@Autowired
	private FlightInfoService service;

	@GetMapping(value = "/location/{locationCode}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<List<FlightInfoDetail>> getFlightDetailsByLocationCode(
			@PathVariable(name = "version", required = true) String version,
			@PathVariable(name = "locationCode", required = true) String locationCode) {
		return service.listFlightInfoByLocationCode(locationCode);
	}

	@GetMapping(value = "/arrival/{flightTime}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<List<FlightInfoDetail>> getFlightDetailsByArrivalTime(
			@PathVariable(name = "version", required = true) String version,
			@PathVariable(name = "flightTime", required = true) String flightTime) {
		return service.listFlightInfoByArrivalTime(flightTime);
	}

}
