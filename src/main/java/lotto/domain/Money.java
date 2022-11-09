package lotto.domain;


public class Money {

    private static final int MONEY_UNIT = 1000;
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 금액은 1000원 단위이어야 합니다.";

    int ticket;

    public void insertMoney(int money){
        validate(money);
        ticket = money / MONEY_UNIT;
    }

    public void validate(int money){
        if (money % MONEY_UNIT > 0){
            System.out.println(MONEY_UNIT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
