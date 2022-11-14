package lotto;

public class Money {

    private int money;

    public Money(String inputMoney) {
        inputMoney = inputMoney.trim();
        validate(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }
    private void validate(String inputMoney) {
        validateForDigit(inputMoney);
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
