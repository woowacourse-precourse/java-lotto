package lotto.validate;

import lotto.enums.IntEnum;

import java.util.List;

public class LottoValidate {
    public void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoDuplicateValidate(numbers);
        lottoRangeValidate(numbers);
    }
    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != IntEnum.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 여섯 자리가 아닙니다.");
        }
    }
    private void lottoDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }
    private void lottoRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < IntEnum.START_NUMBER.getValue() || number > IntEnum.LAST_NUMBER.getValue()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 범위 밖의 숫자입니다.");
            }
        }
    }
}
