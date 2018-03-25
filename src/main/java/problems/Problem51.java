package problems;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Problem51 {
    private static final String ADDRESS_TEXT = "Vitoshka 15";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void solve(EntityManager em) throws IOException {
        em.getTransaction().begin();
        TypedQuery<Boolean> isAddressExists = em.createQuery("select case when (count(a) > 0) then true else false end " +
                "from Address a where text = :text", Boolean.class).setParameter("text", ADDRESS_TEXT);

        TypedQuery<Address> address = em.createQuery("select a from Address a where text = :text", Address.class)
                .setParameter("text", ADDRESS_TEXT);

        if (!isAddressExists.getSingleResult()){
            Address a = new Address();
            a.setText("Vitoshka 15");
            em.persist(a);
        }

        System.out.print("Insert last name of the employee which live on " + ADDRESS_TEXT);
        String lastName = br.readLine();
        List<Employee> empByLastName = em.createQuery("from Employee where lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName).getResultList();

        for (Employee employee : empByLastName) {
            employee.setAddress(address.getSingleResult());
        }

        em.getTransaction().commit();
        em.close();
    }
}
