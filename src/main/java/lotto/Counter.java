package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Counter {
    private int money;

    public Counter() {
        money = 0;
    }

    private void putMoney() {
        String inputMoney = Console.readLine();
        moneyCheck(inputMoney);
    }

    private void moneyCheck(String inputMoney) {
        numberCheck(inputMoney);
        money = Integer.parseInt(inputMoney);
        unitCheck(money);
    }

    private void numberCheck(String inputMoney) {
        try {
            Double.parseDouble(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void unitCheck(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위의 금액이 아닙니다.");
        }
    }
}
