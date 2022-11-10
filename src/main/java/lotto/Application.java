package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositiveNumber(int number) {
        return number > 0;
    }
}
