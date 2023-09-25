/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author Phoom1645
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department dept1 = new Department();
        Department dept2 = new Department();
        
        dept1.setName("IT");
        dept2.setName("HR");
        
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        Employee emp4 = new Employee();
        
        emp1.setName("John");
        emp1.setJob("Network Admin");
        emp1.setSalary(56789.0);
        emp1.setDepartmentid(dept1);
        
        emp2.setName("Marry");
        emp2.setJob("HR Manager");
        emp2.setSalary(46789.0);
        emp2.setDepartmentid(dept2);
        
        emp3.setName("Henry");
        emp3.setJob("Programmer");
        emp3.setSalary(67890.0);
        emp3.setDepartmentid(dept1);
        
        emp4.setName("Clark");
        emp4.setJob("HR recruiter");
        emp4.setSalary(36789.0);
        emp4.setDepartmentid(dept2);

        persist(dept1);
        persist(dept2);
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}