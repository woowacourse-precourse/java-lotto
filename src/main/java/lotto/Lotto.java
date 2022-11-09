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
        lottoNumberException.lottoNumberValidate(numbers);
    }
    // TODO: 추가 기능 구현

    public int getBonusNumber() {
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (numbers.contains(bonusNumber));
        return bonusNumber;
    }
}
