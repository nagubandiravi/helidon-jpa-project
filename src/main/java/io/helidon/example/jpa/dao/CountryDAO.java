package io.helidon.example.jpa.dao;

import io.helidon.example.jpa.model.Country;
import io.helidon.example.jpa.util.DBProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Transactional
public class CountryDAO {

	private EntityManager em;

	@Inject
	public CountryDAO(DBProvider dbProvider) {
		em = dbProvider.getEntityManager();
	}
	
	public Country createCountry(Country country) {
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
		return country;
	}

	public List<Country> getAllCountries() {
		List<Country> countries = em.createNativeQuery("SELECT * FROM COUNTRIES").getResultList();
		return countries;
	}

	public Country getCountryById(String id) {
		Country country = (Country) em.createNativeQuery("SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?", Country.class)
									.setParameter(1, id).getSingleResult();
		return country;
	}

	public Country getCountryByName(String name) {
		Country country = (Country) em.createNativeQuery("SELECT * FROM COUNTRIES WHERE COUNTRY_NAME = ?", Country.class)
				.setParameter(1, name).getSingleResult();
		return country;
	}

	public List<Country> getCountriesByRegion(int regionId) {
		List<Country> countries = em.createNativeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = ?").setParameter(1, regionId).getResultList();
		return countries;
	}

}
