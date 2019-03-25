package com.zzh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 用spring的IOC代替了这个配置文件的功能
 * @author zzh
 *
 */
public class HibernateUtil {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	// 静态代码块实现
	static {
		// 加载核心配置文件
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	// 提供返回与本地线程帮的session的方法
	public static Session getSessionobject() {
		return sessionFactory.getCurrentSession();
	}

	// 提供方法返回sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {

	}
}
