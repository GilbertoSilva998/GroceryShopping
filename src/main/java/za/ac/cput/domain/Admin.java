/**
 * Admin.java
 * This is a POJO class for Admin entity
 *
 * @author Anathi Mhlom 220006695
 * 04 April 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Admin implements Serializable {
    @Id
    private String adminId;
    private String adminName;
    private String adminPassword;
    private String adminEmail;
    private String adminPhone;

    public Admin() {

    }

    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.adminPassword = builder.adminPassword;
        this.adminEmail = builder.adminEmail;
        this.adminPhone = builder.adminPhone;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(adminName, admin.adminName) && Objects.equals(adminPassword, admin.adminPassword) && Objects.equals(adminEmail, admin.adminEmail) && Objects.equals(adminPhone, admin.adminPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, adminPassword, adminEmail, adminPhone);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId: " + adminId +
                "adminName: " + adminName + '\'' +
                "adminPassword: " + adminPassword + '\'' +
                "adminEmail: " + adminEmail + '\'' +
                "adminPhone: " + adminPhone + '\'' +
                "}";
    }

    public static class Builder {
        private String adminId;
        private String adminName;
        private String adminPassword;
        private String adminEmail;
        private String adminPhone;

        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }
        public Builder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        public Builder setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public Builder setAdminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return this;
        }

        public Builder setAdminPhone(String adminPhone) {
            this.adminPhone = adminPhone;
            return this;
        }

        public Builder builder(Admin admin) {
            this.adminId = admin.adminId;
            this.adminName = admin.adminName;
            this.adminPassword = admin.adminPassword;
            this.adminEmail = admin.adminEmail;
            this.adminPhone = admin.adminPhone;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}