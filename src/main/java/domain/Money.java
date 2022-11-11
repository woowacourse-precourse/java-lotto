package domain;

public class Money {

    private final String userAmount;

    public Money(String userAmount) {
        validateNumber(userAmount);
        validateUnit(userAmount);
        this.userAmount = userAmount;
    }

    private void validateNumber(String userAmount) {
        if (!userAmount.matches("^[0-9]$")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력 가능합니다.");
        }
    }


    private void validateUnit(String userAmount) {
        int userMoney = Integer.parseInt(userAmount);
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }


}
