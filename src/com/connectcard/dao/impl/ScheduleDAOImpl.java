package com.connectcard.dao.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.connectcard.dao.MatchupDAO;
import com.connectcard.dao.SchduleDAO;
import com.connectcard.domain.Matchup;
import com.connectcard.domain.Schdule;
import com.connectcard.utility.HibernateUtil;

public class ScheduleDAOImpl implements SchduleDAO{

	public Long saveMatcups(Schdule[] matchups)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Serializable gameId =  null;
		try {
			transaction = session.beginTransaction();
		
		      if (matchups!=null) {
		    	  
		    	             
//		    	                  for (Matchup matchup : matchups) {
//		    	  
//		    	                	  session.save(matchup);
//		    	                  	}
		    	                  for (Schdule sch : matchups){
		    	                	
		    	                   session.save(sch);
		    	    			    }
		    	  
		    	                  }			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 1l;
	}
	
	@SuppressWarnings("unchecked")
	public List<Matchup> getMatchups()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
                List<Matchup> matchups = null;
		try {
			transaction = session.beginTransaction();
			matchups = session.createQuery("from MATCHUP").list();

			for (Matchup matchup: matchups){
				System.out.println("Game ID = "  +matchup.getGameId());
			}

                        
                       
			transaction.commit();
                        
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
                
                  return matchups;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Matchup> getMatchupsByGameId(short week)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
                List<Matchup> matchups= null;
		try {
			transaction = session.beginTransaction();
			matchups = session.createQuery("from Matchup m WHERE m.week = " + week).list();
			
			for (Matchup matchup : matchups){
				System.out.println("Displaying Game IDs " + matchup.getGameId());
			}

                        
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
                
                  return matchups;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplateCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveMatchups(ArrayList<Schdule> matchups) {
		// TODO Auto-generated method stub
		return null;
	}



	



}
