package problems;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Problem11 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void solve(EntityManager em) throws IOException {
        em.getTransaction().begin();
        System.out.print("Finds all employees whose first name starts with:");
        String pattern = br.readLine().toLowerCase() + "%";
        List<Employee> rl = em.createQuery("from Employee e where lower(e.firstName) like :patt", Employee.class)
                .setParameter("patt", pattern).getResultList();

        for (Employee e : rl) {
            System.out.printf("%s %s - %s - ($%.2f)\n",
                    e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());

        }
    }
}
