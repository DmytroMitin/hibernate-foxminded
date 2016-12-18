package com.foxminded.hibernate.onetomany;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.foxminded.hibernate.onetomany.entities.Department;
import com.foxminded.hibernate.onetomany.entities.Employee;
import com.foxminded.hibernate.onetomany.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class App {
	public static void main(String[] args) {
	    // ENTITY MANAGER
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "Hibernate_JPA" );
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("FROM Employee");
        List<Employee> employees = query.getResultList();
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        entityManager.close();
        factory.close();




//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();


		// VALIDATION
//        Query<Employee> query = session.createQuery("FROM Employee");
//        List<Employee> employees = query.list();
//        for (Employee root : employees) {
//            System.out.println(root);
//        }
//
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//		for (Employee root : employees) {
//            Set<ConstraintViolation<Employee>> violations = validator.validate(root);
//            System.out.println(violations);
//        }


        // TASK 3
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//        CriteriaQuery<Employee> joinQuery = query.where(builder.equal(
//                query.from(Employee.class).<Employee, Department>join("department").get("departmentName"),
//                "Sales")
//        );
//        List<Employee> employees = session.createQuery(joinQuery).getResultList();
//        for (Employee root : employees) {
//            System.out.println(root);
//        }

        // TASK 2
//        String s = "FROM Employee E WHERE E.department.departmentName = :department_name";
//        Query<Employee> query = session.createQuery(s);
//        query.setParameter("department_name", "Sales");
//        List<Employee> employees = query.list();
//        for (Employee root : employees) {
//            System.out.println(root);
//        }



        // TASK 1
//        Department department = new Department();
//		department.setDepartmentName("Legal");
//
//		Employee emp1 = new Employee("John", "Jones", "111");
//		Employee emp2 = new Employee("James", "Jameson", "222");
//		department.addEmployee(emp1);
//		department.addEmployee(emp2);
//		session.save(department);
//
//		emp1.setDepartment(department);
//		emp2.setDepartment(department);
//
//		session.save(emp1);
//		session.save(emp2);







//		Department department = new Department();
//		department.setDepartmentName("Sales");
//
//
//		Employee emp1 = new Employee("Nina", "Mayers", "111");
//		Employee emp2 = new Employee("Tony", "Almeida", "222");
//		department.addEmployee(emp1);
//		department.addEmployee(emp2);
//		session.save(department);
//
//		emp1.setDepartment(department);
//		emp2.setDepartment(department);
//
//		session.save(emp1);
//		session.save(emp2);

//		transaction.commit();
//		session.close();
//		sessionFactory.close();


	}
}