/**
 * Product.java
 * This is a POJO class for Product entity
 * @author Asive Sibeko 219475296
 * 03 April 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Product implements Serializable {



    @Id
    private String productId;
    private int productNum;
    private String productType;
    private String productItem;
    private String productDescription;

    public Product(){

    }
    public Product(Builder builder){
        this.productId =  builder.productId;
        this.productNum = builder.productNum;
        this.productType = builder.productType;
        this.productItem = builder.productItem;
        this.productDescription =  builder.productDescription;
    }


    public String getProductId() {
        return productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductItem() {
        return productItem;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductItem(String productItem) {
        this.productItem = productItem;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productNum=" + productNum +
                ", productType='" + productType + '\'' +
                ", productItem='" + productItem + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String productId;
        private int productNum;
        private String productType;
        private String productItem;
        private String productDescription;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductNum(int productNum) {
            this.productNum = productNum;
            return this;
        }

        public Builder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder setProductItem(String productItem) {
            this.productItem = productItem;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder copy(Product product){
            this.productId = product.productId;
            this.productNum = product.productNum;
            this.productType = product.productType;
            this.productItem = product.productItem;
            this.productDescription = product.productDescription;
            return this;
        }
        public Product build(){

            return new Product(this);
        }
    }
}
