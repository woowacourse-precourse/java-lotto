package lotto.validate;

import lotto.enums.IntEnum;

import java.util.List;

public class LottoValidate {
    public void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
    }
    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != IntEnum.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 여섯 자리가 아닙니다.");
        }
    }
}
