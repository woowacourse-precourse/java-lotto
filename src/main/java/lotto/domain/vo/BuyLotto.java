package lotto.domain.vo;

import lotto.enums.ErrorMessage;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int money;

    public BuyLotto(String money) {
        this.money = moneyValidate(money);
//        this.money = Integer.parseInt(money);
        moneyUnitValidate(this.money);
    }

    public int getMoney() {
        return money;
    }

    private void moneyUnitValidate(int money) {
        if (money != -1 && money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_UNIT_MONEY.getErrorMessage());
        }
    }

    private int moneyValidate(String money) {
        try {
            isDigitCheck(money);
            return Integer.parseInt(money);
        }
        catch(IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
            return -1;
        }
    }

    private void isDigitCheck(String money){
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
            }
        }
    }

    public int lottoTicketsCount() {
        return money / LOTTO_PRICE;
    }

}
