package lotto;

public class Money {

    private static final int BASE_AMOUNT = 1_000;

    private final int inputMoney;

    public Money(String inputMoney) {
        this.inputMoney = validateDivideMoney(validateModifyInputMoneyType((inputMoney)));
    }

    private int validateModifyInputMoneyType(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 숫자가 아닙니다.");
        }
    }

    private int validateDivideMoney(int moneyCount) {
        if (moneyCount < BASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원 미만 입니다.");
        }
        return moneyCount / BASE_AMOUNT;
    }

    public int getInputMoney() {
        return inputMoney;
    }

}
