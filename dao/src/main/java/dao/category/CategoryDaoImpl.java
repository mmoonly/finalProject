package dao.category;

import dao.abstractdao.AbstractDao;
import model.category.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDaoImpl extends AbstractDao<Category, Integer> implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    protected Class<Category> getClassType() {
        return Category.class;
    }
}
