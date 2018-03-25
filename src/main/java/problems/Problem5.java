package problems;

import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Problem5 {
    public static void solve(EntityManager em){
        List<Employee> rl = em.createQuery("select e from Employee e join e.department d " +
                "with d.id = 6 " +
                "order by e.salary, e.id", Employee.class).getResultList();
        rl.forEach(e -> System.out.printf("%s %s from %s - $%.2f%n"
                    , e.getFirstName(), e.getLastName()
                    , e.getDepartment().getName(), e.getSalary()));
    }
}
