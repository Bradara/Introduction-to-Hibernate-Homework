package problems;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Problem7 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void solve(EntityManager em) throws IOException {
        em.getTransaction().begin();
        System.out.print("Input Employee ID:");
        int id = Integer.parseInt(br.readLine());

        Employee employee = em.createQuery("from Employee e where e.id = :id", Employee.class)
                .setParameter("id", id).getSingleResult();

        StringBuilder sb = new StringBuilder();
        sb.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                .append(" - ").append(employee.getJobTitle()).append(System.lineSeparator());

        employee.getProjects().stream().map(Project::getName).sorted(String::compareTo)
                .forEach(p -> sb.append(String.format("\t%s\n", p)));

        System.out.println(sb);
        em.close();

    }
}
