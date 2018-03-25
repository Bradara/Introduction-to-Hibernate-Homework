package problems;

import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class Problem2 {
    public static void solve(EntityManager em) {
        em.getTransaction().begin();
        List<Town> towns = em.createQuery("select t from Town t", Town.class).getResultList();
        towns.forEach(t -> {
            if (t.getName().length() > 5)
                em.detach(t);
            else
                t.setName(t.getName().toLowerCase());
        });
        em.getTransaction().commit();
        em.close();
    }
}
