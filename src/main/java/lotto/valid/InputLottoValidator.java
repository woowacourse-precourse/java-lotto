package lotto.valid;

public class InputLottoValidator {

    public void isDigitMoney(String money) {

        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
            }
        }
    }

    public void validateMoney(String money) {
        int integerMoney = Integer.parseInt(money);

        if (integerMoney == 0 || integerMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈을 입력하여야 합니다.");
        }
    }

}
