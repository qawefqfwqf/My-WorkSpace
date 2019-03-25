package com.zzh.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzh.entity.Classroom;
import com.zzh.entity.Student;

@Repository
public class SchoolDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add() {
		Classroom cla = new Classroom();
		cla.setClassName("1班");

		Student stu = new Student();
		stu.setStudentName("zzh");

		cla.getStudents().add(stu);

		Session session = null;

		try {
			session = sessionFactory.getCurrentSession();

			Transaction tx = session.beginTransaction();

			session.save(cla);
			// session.save(stu);

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

			Classroom cla = session.get(Classroom.class, 2);
			session.delete(cla);

			tx.commit();
		} finally {
			session.close();
		}
	}

	public void update() {
		Session session = null;

		try {
			session = sessionFactory.getCurrentSession();

			Transaction tx = session.beginTransaction();
			// 从2班跳到1班去
			Classroom cla = session.get(Classroom.class, 1);
			Student stu = session.get(Student.class, 2);

			cla.getStudents().add(stu);
			stu.setClassroom(cla);

			tx.commit();
		} finally {
			session.close();
		}
	}

}
