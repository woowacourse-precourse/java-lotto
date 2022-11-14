package lotto.util;

public class View {
    public static void print(String message) {
        System.out.print(message);
    }
    
    public static void println(String message) {
        System.out.println(message);
    }
    
    public static void printErrorMessage(Exception e) {
        println("[ERROR] " + e.getMessage());
    }
}
