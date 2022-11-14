package lotto;

import java.util.List;

public class InputValidator {
    public void validatePurchaseAmount(int cash) {
        if (cash != cash / 1000 * 1000 || cash < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public void validateLottoNumber(int number) {
        if (number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateLottoSize(List<Integer> numbers) {

    }
}
