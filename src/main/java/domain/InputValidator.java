package domain;

public class InputValidator {

    public static boolean containOnlyNumber(String input) {
        try {
            validateIsNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void validateIsNumber(String input) {
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("[ERROR] 입력값은 각 자리가 0부터 9 사이의 숫자여야 합니다.");
            }
        }
    }
}
