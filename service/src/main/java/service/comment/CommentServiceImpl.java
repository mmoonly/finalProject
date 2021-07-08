package service.comment;

import dao.comment.CommentDao;
import dao.composition.CompositionDao;
import dao.profile.ProfileDao;
import model.comment.Comment;
import model.composition.Composition;
import model.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.exception.BusinessException;

import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private CompositionDao compositionDao;

    @Transactional
    @Override
    public void addComment(String value, Integer profileId, Integer compositionId) {

        Profile profile = profileDao.findById(profileId);
        if (profile == null) {
            throw new BusinessException("No such profile");
        }
        Composition composition = compositionDao.findById(compositionId);
        if (composition == null) {
            throw new BusinessException("No such composition");
        }
        Comment comment = new Comment(value, LocalDate.now(), profile, composition);
        commentDao.create(comment);
    }

    @Transactional
    @Override
    public void modifyComment(Integer commentId, String newValue) {
        Comment comment = commentDao.findById(commentId);
        if (comment == null) {
            throw new BusinessException("No such comment");
        }
        comment.setValue(newValue);
        commentDao.update(comment);
    }

    @Transactional
    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentDao.findById(commentId);
        if (comment == null) {
            throw new BusinessException("No such comment");
        }
        commentDao.deleteById(commentId);
    }
}
