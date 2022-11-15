package lotto;

public class Money {

    private final int money;

    public Money(String inputMoney) {
        inputMoney = inputMoney.trim();
        validate(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    public int getMoney() {
        return money;
    }

    private void validate(String inputMoney) {
        validateForDigit(inputMoney);
        validateByMinimumAmountUnit(Integer.parseInt(inputMoney));
    }

    private void validateByMinimumAmountUnit(int inputMoney) {
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야만 합니다.");
        }
    }


    private void validateForDigit(String inputMoney) {
        for (char number : inputMoney.toCharArray()) {
            checkDigit(number);
        }
    }
    private void checkDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 공백없이 숫자로만 입력해야 합니다.");
        }
    }
}
