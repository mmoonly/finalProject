package dao.comment;

import dao.abstractdao.AbstractDao;
import model.comment.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDaoImpl extends AbstractDao<Comment, Integer> implements CommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    protected Class<Comment> getClassType() {
        return Comment.class;
    }
}
