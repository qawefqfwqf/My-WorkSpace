package com.zzh.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zzh.entity.Role;
import com.zzh.entity.User;

@Repository
public class UserDao {

	// @Resource
	// public void setSessionFacotry(SessionFactory sessionFacotry) {
	// super.setSessionFactory(sessionFacotry);
	// }

	@Autowired
	private SessionFactory sessionFactory;

	public void add() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();

			Transaction tx = session.beginTransaction();

			User user = new User();
			user.setUsername("张三");
			user.setPassword("zs123456");
			User user2 = new User();
			user2.setUsername("李四");
			user2.setPassword("ls123456");

			Role role = new Role();
			role.setRoleName("小兵");
			Role role2 = new Role();
			role2.setRoleName("排长");
			Role role3 = new Role();
			role3.setRoleName("连长");

			user.getRoles().add(role);
			user.getRoles().add(role2);
			user2.getRoles().add(role2);
			user2.getRoles().add(role3);

			session.save(user);
			session.save(user2);

			tx.commit();
		} finally {
			session.close();
		}

	}

	public void delete() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();

			Transaction tx = session.beginTransaction();

			User user = session.get(User.class, 10);

			session.delete(user);

			tx.commit();
		} finally {
			session.close();
		}

	}

	public List<User> list() {

		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		// Query<UserEntity> query = session.createQuery("from UserEntity");
		//
		// List<UserEntity> list = query.list();

		// Criteria criteria = session.createCriteria(UserEntity.class);
		//
		// List<UserEntity> list = criteria.list();

		// NativeQuery<User> nativeQuery = session.createNativeQuery("select *
		// from db_user", User.class);
		//
		// List<User> list = nativeQuery.list();

		List<User> list = new ArrayList<>();

		// User user = session.get(User.class, 11);
		//
		// Set<Role> roles = user.getRoles();
		//
		// for (Role role : roles) {
		// System.out.println(role.getRoleName());
		// }

		// Hibernate5.3.1中HQL语句使用"?"参数
		// from User where username = ?0 and password = ?1
		String hql = "select count(*) from User";

		Query hqlQuery = session.createQuery(hql);
		
		Object obj=hqlQuery.uniqueResult();//只有一条数据时,使用这个方法
		
		System.out.println(obj);

		tx.commit();

		session.close();

		return list;
	}

}
