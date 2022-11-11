package lotto.domain;

import static lotto.util.LottoUtil.bonusNumberParser;
import static lotto.util.LottoUtil.lottoNumbersParser;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(String inputNumbers, String inputBonusNumber) {
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
