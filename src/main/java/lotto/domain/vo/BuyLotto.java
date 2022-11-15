package lotto.domain.vo;

import lotto.enums.ErrorMessage;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int ONE = -1;
    private final int money;

    public BuyLotto(String money) {
        this.money = moneyValidate(money);
        moneyUnitValidate(this.money);
    }

    public int getMoney() {
        return money;
    }

    private void moneyUnitValidate(int money) {
        if (money != ONE && money % LOTTO_PRICE != ZERO) {
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
            return ONE;
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
