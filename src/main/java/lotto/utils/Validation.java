package lotto.utils;

public class Validation {

    public static void validateMultipleOfThousand(int input) {
        if (!(input % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }
    }

    public static void validateNumber(String input) {

    }
}
