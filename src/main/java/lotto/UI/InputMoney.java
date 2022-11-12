package lotto.UI;

import static lotto.CustomException.throwException;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    private int money;

    public int input() {
        isValidMoney(Console.readLine());
        return money;
    }

    private void isValidMoney(String input) {
        if (isNumber(input)) {
            money = Integer.parseInt(input);
        }
        canBuyLotto(money);
    }

    private boolean isNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자 형태의 입력이어야 합니다.");
            throw e;
        }
        return true;
    }

    private void canBuyLotto(int money) throws IllegalArgumentException {
        if (money < 1000) {
            throwException("[ERROR] 1,000원 보다 커야합니다.");
        }
        if (money / 100 % 10 != 0) {
            throwException("[ERROR] 1,000원 단위가 아닙니다.");
        }
    }
}
