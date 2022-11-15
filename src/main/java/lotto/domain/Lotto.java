package lotto.domain;

import java.util.List;
import lotto.exception.LuckyLottoNumberException;

public class Lotto {
    private List<Integer> numbers;
    private int bonusNumber;

    private final LuckyLottoNumberException luckyLottoNumberException = new LuckyLottoNumberException();

    public Lotto(List<Integer> numbers, int bonusNumber) {
        luckyLottoNumberException.checkLottoBonusNumberExceptions(numbers, bonusNumber);
        luckyLottoNumberException.checkLuckyLottoNumberExceptions(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }



    // TODO: 추가 기능 구현
}
