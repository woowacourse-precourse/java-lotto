package lotto.domain;

import static lotto.util.LottoUtil.bonusNumberParser;
import static lotto.util.LottoUtil.lottoNumbersParser;

import java.util.List;
import lotto.exception.UserInputLottoException;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final UserInputLottoException userInputLottoException = new UserInputLottoException();

    public Lotto(String inputNumbers, String inputBonusNumber) {
        userInputLottoException.validateLotto(inputNumbers, inputBonusNumber);
        this.numbers = lottoNumbersParser(inputNumbers);
        this.bonusNumber = bonusNumberParser(inputBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
