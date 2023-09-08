/**
 * CategoryFactory.java
 * This is a factory class for Category
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.util.Helper;

public class CategoryFactory {

    public static Category createCategory(String categoryName, String categoryType) {
        if (Helper.isNullorEmpty(categoryName) || Helper.isNullorEmpty(categoryType) ) {
            return null;
        }
        String categoryId = Helper.generateId();

        return new Category.Builder().setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setCategoryType(categoryType)
                .build();
    }


}
