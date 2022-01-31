package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // ???????????????????????????????????????????????????????????
    @Override
    public List<User> index() {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User show(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    //    @Override
//    public void save(User user) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        if (user.getId() == null) {
//            em.persist(user);
//        } else {
//            em.merge(user);
//        }
//    }
    @Override
    public void save(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(int id, User updatedUser) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User userToBeUpdated = em.find(User.class, id);

        em.getTransaction().begin();

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());

        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();

    }
}
