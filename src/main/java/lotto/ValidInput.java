package lotto;

import java.util.List;

public class ValidInput {
    public void validCashAmount(Integer cash, Integer lottoDividePrice) {
        if (cash % lottoDividePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 1,000으로 나누어지지 않습니다!");
        }
    }
    public void validInputLength(List<Integer> numbers) {

    }

    public void validIsInputInRange(List<Integer> numbers) {

    }

    public void validInputHasDuplicatedNumber(List<Integer> numbers) {

    }
}
