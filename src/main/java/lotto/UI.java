package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.ErrorType;

public class UI {

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");

        String amount = Console.readLine();

        validateAmount(amount);

        return Integer.parseInt(amount);
    }

    public static void validateAmount(String amount) {

        isNumber(amount);

        int amountNumber = Integer.parseInt(amount);

        isNotZero(amountNumber);

        divisibleThousand(amountNumber);
    }

    public static void isNumber(String amount) {
        for (char letter : amount.toCharArray()) {
            if (letter < '0' || letter > '9') {
                System.out.println(ErrorType.NOT_NUMBER.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNotZero(int amountNumber) {
        if (amountNumber == 0) {
            System.out.println(ErrorType.ZERO_AMOUNT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void divisibleThousand(int amountNumber) {
        if (amountNumber % 1000 != 0) {
            System.out.println(ErrorType.INDIVISIBLE_THOUSAND.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}