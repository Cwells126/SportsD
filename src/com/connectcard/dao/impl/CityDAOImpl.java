
package com.connectcard.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.connectcard.utility.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAOImpl {
/*
 * saction transaction = null;

		Long cityId = null;
		try {
			transaction = session.beginTransaction();
			City city = new City();
			city.setName(cityName);
			cityId = (Long) session.save(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityId;
	}

	@SuppressWarnings("unchecked")
	public List<City> listCities()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
                List<City> cities = null;
		try {
			transaction = session.beginTransaction();
			cities = session.createQuery("from City").list();

			for (City city : cities){
				System.out.println(city.getName());
			}

                        
                       
			transaction.commit();
                        
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
                
                  return cities;
	}

	public void updateCity(Long cityId, String cityName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			City city = (City) session.get(City.class, cityId);
			city.setName(cityName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteCity(Long cityId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			City city = (City) session.get(City.class, cityId);
			session.delete(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
 */
}

