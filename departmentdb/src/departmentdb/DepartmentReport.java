/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import java.util.List;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Phoom1645
 */
public class DepartmentReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Employee> employees = EmployeeTable.findAllEmployee();
        System.out.print("All employee (by ID)");
        System.out.println("------------------------");
        employees.forEach(emp -> {
            System.out.println("ID: " + emp.getDepartmentid());
            System.out.println("Name: " + emp.getName());
            System.out.println("Job: " + emp.getJob());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Department: " + emp.getDepartmentid());
            System.out.println("------------------------");
        });
        
        System.out.println("All employee (by Department)");
        System.out.println("------------------------");
        List<Department> departments = DepartmentTable.findAllDepartment();
        departments.forEach(dep -> {
            System.out.println("Department ID: " + dep.getDepartmentid());
            System.out.println("Department Name: " + dep.getName());
            System.out.println("------------------------");
            employees.forEach(emp -> {
                if(emp.getDepartmentid().getDepartmentid().equals(dep.getDepartmentid()) ){
                    System.out.println("ID: " + emp.getEmployeeid());
                    System.out.println("Name: " + emp.getName());
                    System.out.println("Job: " + emp.getJob());
                    System.out.println("Salary: " + emp.getSalary());   
                    System.out.println("------------------------");
                }           
            });
        });
        
    }
    
}