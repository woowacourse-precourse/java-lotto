package lotto.Exception;

public class Exception {
    public static void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static void isThousands(String input) {
        int money = Integer.parseInt(input);
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }
    }
}
