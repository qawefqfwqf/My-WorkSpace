package com.zzh.dao;

import java.io.Serializable;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzh.entity.User;

@Repository
public class CrudDao {

	@Autowired
	private SessionFactory factory;

	public List<User> list() {
		Session session = factory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		List<User> list = factory.getCurrentSession().createQuery(" from User ").list();

		tx.commit();

		return list;
	}

	public User getOneById(int id) {
		return factory.getCurrentSession().get(User.class, id);
	}

	public Integer add(User user) {
		return (Integer) factory.getCurrentSession().save(user);
	}

	public void update(User user) {
		factory.getCurrentSession().update(user);
	}

	public void delete(int id) {
		factory.getCurrentSession().delete(id);
	}

}
