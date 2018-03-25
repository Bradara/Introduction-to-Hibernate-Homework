package problems;

import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Problem4 {
    public static void solve(EntityManager em){
        List<Employee> rl = em.createQuery("select e from Employee e where salary > 50000", Employee.class).getResultList();
        for (Employee employee : rl) {
            System.out.println(employee.getFirstName());
        }
        em.close();
    }
}
