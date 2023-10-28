package com.proiect.scd.proiectSCD.validator;

import com.proiect.scd.proiectSCD.Role.Role;
import com.proiect.scd.proiectSCD.entity.User;

public class UserValidator {
    public static boolean hasUserRole(User user) {
        if (user.getRole() == null) return false;
        if (user.getRole() != Role.ADMIN && user.getRole() != Role.DIRECTOR) return false;
        return true;
    }
}
