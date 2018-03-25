import problems.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
            EntityManager em = null;


            outside:
            while (true) {
                em = entityManagerFactory.createEntityManager();
                System.out.print("Input which problem to test:");
                String problem = br.readLine();
                try {
                    switch (problem) {
                        case "p2":
                            Problem2.solve(em);
                            continue outside;
                        case "p3":
                            Problem3.solve(em);
                            continue outside;
                        case "p4":
                            Problem4.solve(em);
                            continue outside;
                        case "p5":
                            Problem5.solve(em);
                            continue outside;
                        case "p51":
                            Problem51.solve(em);
                            continue outside;
                        case "p6":
                            Problem6.solve(em);
                            continue outside;
                         case "p7":
                            Problem7.solve(em);
                            continue outside;
                        case "p8":
                            Problem8.solve(em);
                            continue outside;
                        case "p9":
                            Problem9.solve(em);
                            continue outside;
                        case "p10":
                            Problem10.solve(em);
                            continue outside;
                        case "p11":
                            Problem11.solve(em);
                            continue outside;
                        case "p12":
                            Problem12.solve(em);
                            continue outside;
                        case "exit":
                            break outside;
                        default:
                            break outside;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                em.close();
            }
        } catch (Exception e) {
            System.out.println("Problem creating Entity Manager");
            e.printStackTrace();
        } finally {
            br.close();
        }


    }
}
