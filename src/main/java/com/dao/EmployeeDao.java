package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Employee;

public class EmployeeDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("magician");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public Employee empSave(Employee e) throws Exception {
		et.begin();
		em.persist(e);
		et.commit();
		return e;
	}

	public Employee empUpdate(Employee e1) {
		if (e1!=null) {
			et.begin();
			em.merge(e1);
			et.commit();
			return e1;
		}
		else {
			return null;
		}
		
	}
	
	
	
	public Employee deleteEmp(int id) {
		Employee emp = em.find(Employee.class, id);
		if(emp!=null) {
			et.begin();
			em.remove(emp);
			et.commit();
			return emp;
		}else {
			return null;
		}
		
	}

	public Employee fetch(String email) {
		Query q = em.createQuery("select e from Employee e where e.email=?1");
		q.setParameter(1, email);

		return (Employee) q.getSingleResult();

	}
	public Employee fetch(int id) {
		Query q = em.createQuery("select e from Employee e where e.eNo=?1");
		q.setParameter(1, id);

		return (Employee) q.getSingleResult();

	}

	public List<Employee> fetchAll() {
		Query query = em.createQuery("select e from Employee e");
		return query.getResultList();

	}

//	public Employee empUpdate(int id, String name, String email, Long mb, String pass) {
//		Employee e = em.find(Employee.class, id);
//		if (e!=null) {
//			e.setName(name);
//			e.setEmail(email);
//			e.setMobileNo(mb);
//			e.setPassword(pass);
//			et.begin();
//			em.merge(e);
//			et.commit();
//			return e;
//		}
//		else {
//			return null;
//		}
//	}

}
