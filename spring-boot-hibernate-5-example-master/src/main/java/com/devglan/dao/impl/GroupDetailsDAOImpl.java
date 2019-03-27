package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.GroupDetailsDAO;
import com.devglan.dao.UserDao;
import com.devglan.model.GroupDetails;
import com.devglan.model.UserDetails;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class GroupDetailsDAOImpl implements GroupDetailsDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<GroupDetails> getGroupDetails() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery criteria = builder.createQuery(GroupDetails.class);
		Root contactRoot = criteria.from(GroupDetails.class);
		criteria.select(contactRoot);
		return session.createQuery(criteria).getResultList();
	}

}
