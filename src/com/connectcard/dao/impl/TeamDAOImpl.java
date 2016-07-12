package com.connectcard.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connectcard.dao.TeamDAO;
import com.connectcard.domain.Team;
import com.connectcard.utility.HibernateUtil;
	
public class TeamDAOImpl implements TeamDAO{

	@SuppressWarnings("unchecked")
	public Team getTeamIdByTeamNm(String teamNm)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Team team = null;
		try {
			transaction = session.beginTransaction();
			team = (Team) session.createQuery("from Team t WHERE t.teamNm like " + "'" + teamNm + "'").uniqueResult();

			transaction.commit();
                        
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
                
                  return team;
	}
	
	
}
