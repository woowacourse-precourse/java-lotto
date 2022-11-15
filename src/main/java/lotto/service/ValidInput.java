package lotto.service;

import java.util.List;
import java.util.Objects;
import lotto.business.model.LottoEnum;

public class ValidInput {
    public void validCashAmount(Integer cash, Integer lottoDividePrice) {
        if (cash % lottoDividePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 1,000으로 나누어지지 않습니다!");
        }
    }
    public void validInputLength(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6자리로 이루어져있지 않습니다!");
        }
    }

    public void validIsInputInRange(Integer number) {
        if (number < LottoEnum.START_NUM.getValue() || number > LottoEnum.END_NUM.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 " + LottoEnum.START_NUM.getValue() + "과 " +
                    LottoEnum.END_NUM.getValue() + "사이에 있지 않습니다!");
        }
    }

    public void validInputHasDuplicatedNumber(List<Integer> numbers) {
        for (int count1 = 0; count1 < numbers.size(); count1++) {
            divideDuplicatedValidLogic(numbers, count1);
        }
    }

    private void divideDuplicatedValidLogic(List<Integer> numbers, int count1) {
        for (int count2 = count1 + 1; count2 < numbers.size(); count2++) {
            checkDuplicated(numbers, count1, count2);
        }
    }

    private void checkDuplicated(List<Integer> numbers, int count1, int count2) {
        if (Objects.equals(numbers.get(count1), numbers.get(count2))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다!");
        }
    }
}
