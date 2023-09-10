package za.ac.cput.service;

import za.ac.cput.domain.Category;
import java.util.List;

public interface ICategoryService extends IService<Category, String> {
    List<Category> getAll();
}
