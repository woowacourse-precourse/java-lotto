package lotto;

import static lotto.LottoWinType.matchGameScoreAndLottoWinType;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constant;
import lotto.utils.ValidateUtils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidateUtils.checkDuplicateNumber(numbers);
        ValidateUtils.checkArraySize(numbers.size(), Constant.LOTTO_SIZE);
        ValidateUtils.checkRangeNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public LottoWinType findMatchedLotto(List<Integer> myLotto, List<Integer> winLotto, int bonusLotto) {
        int answerCount = 0;
        int bonusCount = 0;
        for (Integer number : myLotto) {
            if (winLotto.contains(number)) {
                answerCount++;
            }

            if (number == bonusLotto) {
                bonusCount++;
            }
        }
        return matchGameScoreAndLottoWinType(answerCount, bonusCount);
    }

}
