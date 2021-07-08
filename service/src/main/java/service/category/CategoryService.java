package service.category;

public interface CategoryService {

    void addCategory(String thread);

    void addCategoryWithParent(Integer categoryId, String thread);

    void modifyCategory(Integer categoryId, String thread);

    void deleteCategory(Integer categoryId);
}
