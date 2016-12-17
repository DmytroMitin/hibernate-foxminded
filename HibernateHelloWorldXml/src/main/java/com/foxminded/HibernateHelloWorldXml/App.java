package com.foxminded.HibernateHelloWorldXml;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;

import com.foxminded.HibernateHelloWorldXml.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + PosgreSQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(new Random().nextInt(100_000));
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
	}
}