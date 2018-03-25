package problems;

import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Problem9 {
    public static void solve(EntityManager em){
        em.getTransaction().begin();
        List<Employee> resultList = em.createQuery("from Employee e where e.department.name = 'Engineering' or " +
                "e.department.name = 'Tool Design' or e.department.name = 'Marketing' or " +
                "e.department.name = 'Information Services'", Employee.class).getResultList();
        for (Employee e : resultList) {
            e.setSalary(e.getSalary().multiply(new BigDecimal("1.12")));
            System.out.printf("%s %s ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getSalary());
        }

        em.getTransaction().commit();
        em.close();
    }
}
