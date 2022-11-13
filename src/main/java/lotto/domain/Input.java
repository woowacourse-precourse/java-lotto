package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int purchaseAmount() {
        String amount = Console.readLine();

        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구매 금액 입니다.");
        }

        return Integer.parseInt(amount);
    }

    private static boolean isValidAmount(String number) {
        return isNumeric(number) && isPositive(number) && isDividedBy1000(number);
    }

    private static boolean isNumeric(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private static boolean isPositive(String number) {
        return Integer.parseInt(number) > 0;
    }

    private static boolean isDividedBy1000(String number) {
        return Integer.parseInt(number) % 1000 == 0;
    }
}
