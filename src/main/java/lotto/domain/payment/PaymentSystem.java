package lotto.domain.payment;

import camp.nextstep.edu.missionutils.Console;

public class PaymentSystem {

    public void validateForm(String userInput) {
        if (!userInput.matches("\\d{1,}")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
    }

    private void validateAmount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}
