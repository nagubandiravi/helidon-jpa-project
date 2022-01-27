package io.helidon.example.jpa.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import io.helidon.example.jpa.dao.CountryDAO;
import io.helidon.example.jpa.model.Country;

import java.util.List;

@Path("/country")
public class CountryResource {
	
	@Inject
	CountryDAO dao;
	
	@POST
	public Country createCountry(Country country) {
		return dao.createCountry(country);
	}

	@GET
	@Path("/all")
	public List<Country> getAllCountries() {
		List<Country> countries = dao.getAllCountries();
		return countries;
	}

	@GET
	@Path("/id/{id}")
	public Country getCountryById(@PathParam("id") String id) {
		return dao.getCountryById(id);
	}

	@GET
	@Path("/name/{name}")
	public Country getCountryByName(@PathParam("name") String name) {
		return dao.getCountryByName(name);
	}

	@GET
	@Path("/all/regionid/{regionid}")
	public List<Country> getCountriesByRegionId(@PathParam("regionid") int regionId) {
		List<Country> countries = dao.getCountriesByRegion(regionId);
		return countries;
	}

}
