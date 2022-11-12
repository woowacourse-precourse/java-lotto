package lotto;

public class CustomException {
    public static void throwException(String s) throws IllegalArgumentException {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(s);
            throw e;
        }
    }
}
