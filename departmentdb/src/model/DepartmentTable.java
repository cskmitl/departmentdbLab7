/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Phoom1645
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;





/**
 *
 * @author Phoom1645
 */
public class DepartmentTable {
    public static void insertDepartment(Department emp) {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = dept.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateDepartment(Department dep) {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager dp = dept.createEntityManager();
        Department fromDb = dp.find(Department.class, dep.getDepartmentid());
        fromDb.setName(dep.getName());
        dp.getTransaction().begin();
        try {
            dp.persist(fromDb);
            dp.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            dp.getTransaction().rollback();
        } finally {
            dp.close();
        }
    }
    public static Department findDepartmentById(Integer id) {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager dp = dept.createEntityManager();
        Department emp = dp.find(Department.class, id);
        dp.close();
        return emp;
    }
    public static List<Department> findAllDepartment() {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager dp = dept.createEntityManager();
        List<Department> deptList = (List<Department>) dp.createNamedQuery("Department.findAll").getResultList();
        dp.close();
        return deptList;
    }
    public static List<Department> findDepartmentByName(String name) {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager dp = dept.createEntityManager();
        Query query = dp.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> stdList = (List<Department>) query.getResultList();
        dp.close();
        return stdList;
    }
    public static void removeDepartment(Department dep) {
        EntityManagerFactory dept = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager dp = dept.createEntityManager();
        Department fromDb = dp.find(Department.class, dep.getDepartmentid());
        dp.getTransaction().begin();
        try {
            dp.remove(fromDb);
            dp.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            dp.getTransaction().rollback();
        } finally {
            dp.close();
        }
                
    }
}