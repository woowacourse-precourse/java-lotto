package lotto;

public class Exception {
    public static int isInteger(String str) {
        int integer;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수를 입력해야 합니다.");
        }

        return integer;
    }

    public static boolean isNotMultipleOfThousand(int money) {
        return money % 1000 != 0;
    }

    public static boolean isNotPositive(int money) {
        return money <= 0;
    }
}
