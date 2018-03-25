package problems;

import entities.Project;

import javax.persistence.EntityManager;
import java.util.List;

public class Problem8 {
    public static void  solve(EntityManager em){
        em.getTransaction().begin();
        List<Project> projects = em.createQuery("from Project p " +
                "order by p.startDate desc", Project.class)
                .setMaxResults(10).getResultList();
        for (Project p : projects) {
            System.out.printf("Project name: %s\n" +
                    "\tProject Description: %s\n" +
                    "\tProject Start Date:%s\n" +
                    "\tProject End Date: %s\n", p.getName()
            ,p.getDescription(), p.getStartDate(), p.getEndDate());
        }

        em.close();
    }
}
