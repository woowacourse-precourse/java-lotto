package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Input {
    public static int insertPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String purchaseMoney = Console.readLine();
        checkNumber(purchaseMoney);
        return parseInt(purchaseMoney);
    }

    private static void checkNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("문자열이 아닌 숫자(정수)를 입력해주세요.");
        }
    }
}
