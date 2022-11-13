package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
    private final int LOTTERY_PRICE;

    public InputOutput(int lotteryPrice) {
        LOTTERY_PRICE = lotteryPrice;
    }

    public int moneyInput() {
        int money;

        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자이어야 합니다.");
            throw new IllegalArgumentException();
        }

        if (money % LOTTERY_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 " + LOTTERY_PRICE + "단위 이어야 합니다.");
            throw new IllegalArgumentException();
        }

        if (money <= 0) {
            System.out.println("[ERROR] 구입 금액은 " + LOTTERY_PRICE + "이상만 가능합니다.");
            throw new IllegalArgumentException();
        }

        return money;
    }
}
