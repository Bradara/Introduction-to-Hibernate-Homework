package problems;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Problem10 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void solve(EntityManager em) throws IOException {
        System.out.print("Input town name:");
        String townName = br.readLine();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        Town town = em.createQuery("from Town t where t.name = :name", Town.class)
                .setParameter("name", townName).getSingleResult();
        List<Address> addresses = em.createQuery("from Address a where a.town.name = :name", Address.class)
                .setParameter("name", townName).getResultList();
        int numberOfAddresses = addresses.size();
        addresses.forEach(em::remove);
        em.remove(town);
        em.getTransaction().commit();

        if (numberOfAddresses > 0)
            System.out.println(numberOfAddresses + " addresses in " + townName +" deleted");
        else
            System.out.println(numberOfAddresses + " address in " + townName +" deleted");
        System.out.println();
        em.close();
    }
}
