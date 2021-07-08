package dao.composition;

import dao.abstractdao.AbstractDao;
import model.composition.Composition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CompositionDaoImpl extends AbstractDao<Composition, Integer> implements CompositionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    protected Class<Composition> getClassType() {
        return Composition.class;
    }
}
