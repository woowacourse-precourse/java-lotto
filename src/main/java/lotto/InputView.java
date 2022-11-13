package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return getMoney(Console.readLine());
    }

    public static int getMoney(String input) {
        MoneyValidator.validateMoney(input);
        int money = Integer.parseInt(input);
        System.out.println();

        return money / 1000;
    }
}
