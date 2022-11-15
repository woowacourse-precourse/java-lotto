package lotto.domain;

import java.util.NoSuchElementException;

public class Money {
    public static final String ERROR_INPUT_MONEY = "[ERROR]숫자만 입력해주세요.";

    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_VALID_MONEY = "[ERROR]1000원 단위로 입력해주세요.";

    private int money;

    public Money(String inputmoney) {
        try {
            this.money = convertToInt(inputmoney);
        }catch(IllegalArgumentException e){
            System.out.println(ERROR_INPUT_MONEY);
            throw new NoSuchElementException(ERROR_INPUT_MONEY);
        }
        validateMoney(this.money);
    }

    public void validateMoney(int money) {
        isCalculator(money);
    }

    public int calculateLottoAmount() {
        return this.money / LOTTO_PRICE;
    }

    public static int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
    }

    private void isCalculator(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.println(NOT_VALID_MONEY);
            throw new IllegalArgumentException(NOT_VALID_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }

}
