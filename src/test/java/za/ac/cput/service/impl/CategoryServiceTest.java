package za.ac.cput.service.impl;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.service.impl.CategoryService;
import za.ac.cput.domain.Category;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

public class CategoryServiceTest {

    @Autowired
    private CategoryService service;
    private static Category category = CategoryFactory.createCategory("Meat","Beef");
    @Test
    void a_create() {
        Category created = service.create(category);
        assertEquals(category.getCategoryId(), created.getCategoryId());
        System.out.println("created:"+ created);
    }

    @Test
    void b_read() {
        Category read = service.read(category.getCategoryId());
        assertNotNull(read);
        System.out.println("Read:"+ read);
    }

    @Test
    void c_update() {
        Category newCategory = new Category.Builder().copy(category).setCategoryType("Mutton").build();
        Category updated= service.update(newCategory);
        assertEquals(newCategory.getCategoryType(), updated.getCategoryType());
        System.out.println("Updated:"+ updated);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(service.getAll());
    }
}
