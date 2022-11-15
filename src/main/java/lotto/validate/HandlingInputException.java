package lotto.validate;

public class HandlingInputException {

    public void consistOnlyNumbers(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            char number = purchaseAmount.charAt(i);

            if (number < '0' || number >'9') {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
    }

    public void checkRightRange(int purchaseAmount) {

        if (purchaseAmount / 1000 < 1) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 구매해야 합니다.");
        }
    }

    public void checkRightUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매해야 합니다.");
        }
    }
}
