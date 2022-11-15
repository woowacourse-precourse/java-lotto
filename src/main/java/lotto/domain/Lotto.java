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
    public List<Integer> getNumbers() {
        return numbers;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        luckyLottoNumberException.checkLuckyLottoNumberExceptions(numbers);
    }




    // TODO: 추가 기능 구현
}
