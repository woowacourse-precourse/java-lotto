package lotto.user;

public class UserValidator {

    public void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정상적인 정수를 입력해주세요.");
        }
    }

    public void validateUnit(Integer money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액은 반드시 1,000원 단위로 입력되어야 합니다.");
    }

    public Integer toInteger(String money) {
        validateInteger(money);
        Integer moneyInteger = Integer.parseInt(money);

        validateUnit(moneyInteger);
        return moneyInteger;
    }

}
