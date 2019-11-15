package com.robinson.softwaricaapp.controller;

import com.robinson.softwaricaapp.model.UserData;

public class ControllerClass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("admin")) && (sd.getPassword().equals("admin"))) {
            return true;

        } else {
            return false;
        }
    }

}
