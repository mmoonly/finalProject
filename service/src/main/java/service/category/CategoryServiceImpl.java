package service.category;

import dao.category.CategoryDao;
import model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.exception.BusinessException;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public void addCategory(String thread) {
        Category category = new Category(thread);
        categoryDao.create(category);
    }

    @Transactional
    @Override
    public void addCategoryWithParent(Integer categoryId, String thread) {
        Category parent = categoryDao.findById(categoryId);
        if (parent == null) {
            throw new BusinessException("No such category");
        }
        Category category = new Category(thread, parent);
        categoryDao.create(category);
    }

    @Transactional
    @Override
    public void modifyCategory(Integer categoryId, String thread) {
        Category category = categoryDao.findById(categoryId);
        if (category == null) {
            throw new BusinessException("No such category");
        }
        category.setThread(thread);
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryDao.findById(categoryId);
        if (category == null) {
            throw new BusinessException("No such category");
        }
        if (category.getParent() != null) {
            throw new BusinessException("Can't delete parent category");
        }
        categoryDao.deleteById(categoryId);
    }
}
