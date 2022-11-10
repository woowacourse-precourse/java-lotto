package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoNumberException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    LottoNumberException lottoNumberException = new LottoNumberException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoNumberException.lottoNumberSize(numbers);
        lottoNumberException.lottoNumberDuplicated(numbers);
        lottoNumberException.lottoNumberMaxMin(numbers);
    }
    // TODO: 추가 기능 구현
}
