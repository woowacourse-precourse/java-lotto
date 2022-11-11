package lotto.domain;


public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_INPUT_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    private static final String NOT_VALID_MONEY = "[ERROR] 1000원 단위로 입력해주세요.";
    private final int money;

    public Money(String money) {
        this.money = convertToInt(money);
        validateMoney(this.money);
    }

    public void validateMoney(int money) {
        if(calculator(money)){
            throw new IllegalArgumentException(NOT_VALID_MONEY);
        }
    }

    private boolean calculator(int money) {
        return money % LOTTO_PRICE != 0 || money < 0;
    }

    private int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
        }
    }



}
