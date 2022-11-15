package lotto.game;

import java.util.HashSet;
import java.util.List;
import lotto.common.Constant;
import lotto.ui.Error;

public class Lotto {

    private final static int LOTTO_NUMBER_INDEX = 0;
    private final static int BONUS_NUMBER_INDEX = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBERS_INPUT_SIZE) {
            throw new IllegalArgumentException(Error.lottoNumberSizeException());
        }
        if (new HashSet<>(numbers).size() != Constant.LOTTO_NUMBERS_INPUT_SIZE) {
            throw new IllegalArgumentException(Error.nonDuplicatedLottoNumbersException());
        }
    }

    public LottoResult getLottoResult(List<Integer> winningLottoNumbers, int bonusNumber) {
        List<Integer> matchedNumbers = getMatchedNumbers(winningLottoNumbers, bonusNumber);
        int lottoNumbersCount = matchedNumbers.get(LOTTO_NUMBER_INDEX);
        int bonusNumberCount = matchedNumbers.get(BONUS_NUMBER_INDEX);
        return LottoResult.get(lottoNumbersCount, bonusNumberCount);
    }

    private List<Integer> getMatchedNumbers(List<Integer> winningLottoNumbers, int bonusNumber) {
        int matchedWinningLottoNumbersCount = Constant.INITIAL_COUNT;
        int matchedBonusNumberCount = Constant.INITIAL_COUNT;
        for (int number : this.numbers) {
            if (winningLottoNumbers.contains(number)) {
                matchedWinningLottoNumbersCount++;
            }
            if (bonusNumber == number) {
                matchedBonusNumberCount++;
            }
        }
        return List.of(matchedWinningLottoNumbersCount, matchedBonusNumberCount);
    }
}
