/**
 * Category.java
 * This is a POJO class for Category entity
 * @author Sinentlahla Pindani 219081328
 * 04 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Category implements Serializable {
   @Id
    private String categoryId;
    private String categoryName;
    private String categoryType;
    public Category(){

    }
    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.categoryType = builder.categoryType;

    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }

    public static class Builder{
        private String categoryId;
        private String categoryName;
        private String categoryType;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder setCategoryType(String categoryType) {
            this.categoryType = categoryType;
            return this;
        }

        public Category.Builder copy(Category category){
            this.categoryId = category.categoryId;
            this.categoryName = category.categoryName;
            this.categoryType = category .categoryType;
            return this;
        }

        public Category build(){

            return new Category(this);
        }

    }
}
