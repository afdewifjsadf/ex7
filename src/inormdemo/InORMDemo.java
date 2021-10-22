/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inormdemo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ub
 */
public class InORMDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FullTimeEmp emp1 = new FullTimeEmp();
//        emp1.setId((long) 1);
//        emp1.setName("rat");
//        emp1.setSalary(50000);
        PartTimeEmp emp2 = new PartTimeEmp();
//        emp2.setId((long) 2);
//        emp2.setName("Jason");
//        emp2.setHoursWork(18);
//        insertEmployee(emp1);
//        insertEmployee(emp2);
//        System.err.println(emp1.getId());
//        updateFullTimeEmployee(emp1);
//        updatePartTimeEmployee(emp2);
//        removeFullTimeEmployee(emp1);
//        removePartTimeEmployee(emp2);
        Scanner sc = new Scanner(System.in);
        long id;
        String name;
        int salary, hoursWork, s;
        do {
            System.out.println("1. insertFullTimeEmployee");
            System.out.println("2. insertPartTimeEmployee");
            System.out.println("3. updateFullTimeEmployee");
            System.out.println("4. updatePartTimeEmployee");
            System.out.println("5. removeFullTimeEmployee");
            System.out.println("6. removePartTimeEmployee");
            System.out.println("0. Exit");
            System.out.print("Select : ");
            s = sc.nextInt();
            switch (s) {
                case 1:
                    System.out.println("\nSetinsertFullTimeEmployee [name, salary]:");
                    name = sc.next();
                    salary = sc.nextInt();
                    emp1.setName(name);
                    emp1.setSalary(salary);
                    insertEmployee(emp1);
                    break;
                case 2:
                    System.out.println("\nSetinsertPartTimeEmployee [name, hoursWork]:");
                    name = sc.next();
                    hoursWork = sc.nextInt();
                    emp2.setName(name);
                    emp2.setHoursWork(hoursWork);
                    insertEmployee(emp2);
                    break;
                case 3:
                    System.out.println("\nSetupdateFullTimeEmployee [id, name, salary]:");
                    id = sc.nextLong();
                    name = sc.next();
                    salary = sc.nextInt();
                    emp1.setId(id);
                    emp1.setName(name);
                    emp1.setSalary(salary);
                    updateFullTimeEmployee(emp1);
                    break;
                case 4:
                    System.out.println("\nSetupdatePartimeEmployee [id, name, hoursWork]:");
                    id = sc.nextLong();
                    name = sc.next();
                    hoursWork = sc.nextInt();
                    emp2.setId(id);
                    emp2.setName(name);
                    emp2.setHoursWork(hoursWork);
                    updatePartTimeEmployee(emp2);
                    break;
                case 5:
                    System.out.println("\nSetremoveFullTimeEmployee [id]:");
                    id = sc.nextLong();
                    emp1.setId(id);
                    removeFullTimeEmployee(emp1);
                    break;
                case 6:
                    System.out.println("\nSetremovePartimeEmployee [id]:");
                    id = sc.nextLong();
                    emp2.setId(id);
                    removePartTimeEmployee(emp2);
                    break;

            }
            System.out.println("\n-------------------------------------------");

        } while (s != 0);

        System.out.println("ty for use it!");

    }

    public static void insertEmployee(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InORMDemoPU");
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

    public static void updateFullTimeEmployee(FullTimeEmp emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InORMDemoPU");
        EntityManager em = emf.createEntityManager();
        FullTimeEmp fromDb = em.find(FullTimeEmp.class, emp.getId());
        fromDb.setName(emp.getName());
        fromDb.setSalary(emp.getSalary());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updatePartTimeEmployee(PartTimeEmp emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InORMDemoPU");
        EntityManager em = emf.createEntityManager();
        PartTimeEmp fromDb = em.find(PartTimeEmp.class, emp.getId());
        fromDb.setName(emp.getName());
        fromDb.setHoursWork(emp.getHoursWork());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void removeFullTimeEmployee(FullTimeEmp emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InORMDemoPU");
        EntityManager em = emf.createEntityManager();
        FullTimeEmp fromDb = em.find(FullTimeEmp.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void removePartTimeEmployee(PartTimeEmp emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InORMDemoPU");
        EntityManager em = emf.createEntityManager();
        PartTimeEmp fromDb = em.find(PartTimeEmp.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
