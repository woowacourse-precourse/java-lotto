package lotto.model;

import lotto.view.InputView;
import lotto.enums.Error;

public class Money {
    private int inputMoney;
    private int tickets;

    public void setInputMoney() {
        String input = InputView.purchaseInput();
        int money = isMoneyNumber(input);
        if(isMoneyValid(money)) this.inputMoney = money;
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
    public int getLottoTickets() {
        return this.inputMoney/1000;
    }
}