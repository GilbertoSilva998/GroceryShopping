/**
 * AdminFactory.java
 * This is a Factory class for Admin entity
 *
 * @author Anathi Mhlom 220006695
 * 06 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(String adminName, String adminPassword, String adminEmail, String adminPhone) {
        if (Helper.isNullorEmpty(adminName)) {
            if (Helper.isNullorEmpty(adminPassword)) {
                Helper.isNullorEmpty(adminPhone);
            }
            if (Helper.isValidEmail(adminEmail)) {
                return null;
            }
            return null;
        }
        String adminId = Helper.generateId();

        return new Admin.Builder()
                .setAdminId(adminId)
                .setAdminName(adminName)
                .setAdminPassword(adminPassword)
                .setAdminEmail(adminEmail)
                .setAdminPhone(adminPhone)
                .build();
    }
}