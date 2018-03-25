package problems;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Problem3 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void solve(EntityManager em) throws IOException {
        System.out.print("Input name:");
        String[] name = br.readLine().split("\\s+");
        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("select e from Employee e ", Employee.class).getResultList();
        boolean isMAtch = employees.stream().anyMatch(e -> e.getLastName().equals(name[1]) && e.getFirstName().equals(name[0]));

        if (isMAtch)
            System.out.println("Yes");
        else
            System.out.println("No");
        em.close();
    }
}
