package problems;

import entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class Problem6 {
    public static void solve(EntityManager em){
        em.getTransaction().begin();

        List<Address> resultList = em.createQuery("select a from Address a " +
                "order by a.employees.size desc, a.town.id", Address.class).setMaxResults(10).getResultList();

        for (Address a : resultList) {
            System.out.printf("%d %s, %s - %d employees%n", a.getId(), a.getText()
            , a.getTown().getName(), a.getEmployees().size());
        }
        em.close();

    }
}
