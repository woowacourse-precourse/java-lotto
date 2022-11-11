package lotto.domain;


import lotto.view.Output;

public class Money {

    private static final Integer MONEY_UNIT = 1000;
    private static final String MONEY_UNIT_ERROR_MESSAGE = "금액은 1000원 단위이어야 합니다.";
    private static final String MONEY_MUST_DIGIT = "올바른 금액을 입력해주세요.";

    private final Integer money;

    public Money(String money) {
        validateDigit(money);
        validateUnit(Integer.parseInt(money));
        this.money = Integer.parseInt(money);
    }

    public Integer getTicket() {
        return money / MONEY_UNIT;
    }

    public Integer getMoney() {
        return money;
    }

    private void validateUnit(Integer money) {
        if (money % MONEY_UNIT > 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDigit(String money){
        for (int index = 0; index < money.length(); index++) {
            if(!Character.isDigit(money.charAt(index))){
                throw new IllegalArgumentException("[ERROR] 에러");
            }
        }
    }
}
