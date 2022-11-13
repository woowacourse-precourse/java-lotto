package lotto;

import java.util.List;

public class Exception {
    public static int inputTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        int money = Integer.parseInt(input);
        return money;
    }
    public static void rangeError(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력해야 합니다.");
        }
    }

    public static void duplicate(List<Integer> winNums, int number) {
        if (winNums.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수를 입력하였습니다.");
        }
    }


    public static void winNumInputError(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static void moneyInputError(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000 단위여야 합니다.");
        }
    }




}
