package lotto.model;

import lotto.view.InputView;
import lotto.enums.Error;

public class Money {
    private static int inputMoney;

    public static void setInputMoney() {
        String input = InputView.purchaseInput();
        int money = isMoneyNumber(input);
        if(isMoneyValid(money)) inputMoney = money;
    }
    public static Integer isMoneyNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.PURCHASE_NUMERIC.getError());
        }
    }
    public static boolean isMoneyValid(int money) {
        if(money < 1000) throw new IllegalArgumentException(Error.PURCHASE_MIN.getError());
        if(money % 1000 != 0) throw new IllegalArgumentException(Error.PURCHASE_UNIT.getError());
        return true;
    }
    // 입력 받은 money 유효성 검사
    // 로또 발행 수량 구하기

}