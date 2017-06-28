package ru.netcracker.migalin.util;

import java.awt.*;
import java.util.ArrayList;

public class Util {
    public static void checkInputParameter(String... input){
        for (String checkString:
             input) {
            if (checkString.length()<3) throw new IllegalArgumentException("The length of the entered parameters must be greater than 2");
        }
    }
}
