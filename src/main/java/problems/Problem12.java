package problems;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Problem12 {
    public static void solve(EntityManager em) {
        em.getTransaction().begin();
        List<Object[]> resultList = em.createQuery("select e.department.name, max(e.salary) as sal from Employee e " +
                "group by e.department").getResultList();

        int size = resultList.size();

        for (int i = 0; i < size; i++) {
            String name = (String) resultList.get(i)[0];
            BigDecimal salary = (BigDecimal) resultList.get(i)[1];

            if (salary.compareTo(new BigDecimal(70000)) > 0 ||
                    salary.compareTo(new BigDecimal(30000)) < 0)
                System.out.println(name + " - " + salary);

        }

        em.close();
    }
}
