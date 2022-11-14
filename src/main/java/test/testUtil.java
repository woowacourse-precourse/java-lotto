package test;

import java.io.ByteArrayInputStream;

public class testUtil {
    public static void input(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
