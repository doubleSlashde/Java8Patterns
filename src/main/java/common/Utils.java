package common;

import java.util.Collections;

public class Utils {
    
    public static void printHeader(String s) {
        System.out.println(header(s));
    }
    
    public static String header(String s) {
        int length = s.length() + 5;
        return "\n" + line(length) + "\n-- " + s + "\n" + line(length) + "\n";
    }

    private static String line(int length) {
        return String.join("", Collections.nCopies(length, "-"));
    }
}
