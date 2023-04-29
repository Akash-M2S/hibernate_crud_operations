package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;

import dto.Empdetails;

public class EmpDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void addEmp(String ename, long mobile, String jobRole, double sal) {
		try {
			entityTransaction.begin();
			Empdetails empdetails = new Empdetails();
			empdetails.setEname(ename);
			empdetails.setMobile(mobile);
			empdetails.setJobRole(jobRole);
			empdetails.setSal(sal);
			entityManager.persist(empdetails);
			entityTransaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateSal(int id, double sal) {

		Empdetails empdetails = entityManager.find(Empdetails.class, id);
		if (empdetails != null) {
			entityTransaction.begin();
			empdetails.setSal(sal);
			entityManager.merge(empdetails);
			entityTransaction.commit();
			System.out.println("salary updated");
		} else {
			System.out.println("enter the correct id");
		}

	}

	public void delete(int id) {

		Empdetails empdetails = entityManager.find(Empdetails.class, id);
		if (empdetails != null) {
			entityTransaction.begin();
			entityManager.remove(empdetails);
			entityTransaction.commit();
			System.out.println("deleted");
		} else {
			System.out.println("data not exist");
		}

	}

	public void deleteAll() {
		entityTransaction.begin();
		Query query = entityManager.createQuery("delete from Empdetails");
	     query.executeUpdate();
		entityTransaction.commit();

	}

	public void fetch(int id) {
		Empdetails empdetails = entityManager.find(Empdetails.class, id);
		if (empdetails != null) {
			System.out.println(empdetails);
		} else {
			System.out.println("data not exist");
		}

	}

	public void fetchAll() {
		Query query = entityManager.createQuery("select a from Empdetails a");
		List<Empdetails> list = query.getResultList();
		for (Empdetails a : list) {
			System.out.println(a);
		}

	}

}
