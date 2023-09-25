/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author Phoom1645
 */
public class EmployeeTable {
  
    
//    public static Department findEmployeeByDepartmentId(Integer id) {
//        EntityManagerFactory emp = Persistence.createEntityManagerFactory("departmentDBPU");
//        EntityManager em = emp.createEntityManager();
//        Employee emp = em.find(Employee.class, id);
//        em.close();
//        return emp;
//    }
    public static List<Employee> findEmployeeByName(String name) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager sd = stf.createEntityManager();
        Query query = sd.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Employee> stdList = (List<Employee>) query.getResultList();
        sd.close();
        return stdList;
    }
    public static List<Employee> findAllEmployee() {
        EntityManagerFactory emp = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emp.createEntityManager();
        List<Employee> empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        return empList;
    }
}