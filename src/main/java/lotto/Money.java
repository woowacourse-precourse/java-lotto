package lotto;

public class Money {

    private int money;

    public Money(String inputMoney) {
        validate(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    private void validate(String inputMoney) {


    }
}
