import br.edu.ifsul.condominiomodel.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jakelyny Sousa
 */
public class TestePessoa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2022-1-Model-CondominioPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Jakelyny Sousa");
        p.setCpf("12345678910");
        p.setTelefone("9832375622");
        p.setEmail("jake@gmail.com");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close(); 
    }
}
