package lotto.game;

import java.util.HashSet;
import java.util.List;
import lotto.common.Constant;
import lotto.ui.Print;

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
            Print.lottoNumberSizeException();
            throw new IllegalArgumentException();
        }
        if (new HashSet<>(numbers).size() != Constant.LOTTO_NUMBERS_INPUT_SIZE) {
            Print.nonDuplicatedLottoNumbersException();
            throw new IllegalArgumentException();
        }
    }

    public LottoResult getLottoResult(List<Integer> winningLottoNumbers, int bonusNumber) {
        List<Integer> matchedNumbers = getMatchedNumbers(winningLottoNumbers, bonusNumber);
        int lottoNumbersCount = matchedNumbers.get(LOTTO_NUMBER_INDEX);
        int bonusNumberCount = matchedNumbers.get(BONUS_NUMBER_INDEX);
        if (lottoNumbersCount == Constant.FIFTH_MATCHED_NUMBER_COUNT) {
            return LottoResult.FIFTH;
        }
        if (lottoNumbersCount == Constant.FOURTH_MATCHED_NUMBER_COUNT) {
            return LottoResult.FOURTH;
        }
        if (lottoNumbersCount == Constant.THIRD_MATCHED_NUMBER_COUNT
                && bonusNumberCount == Constant.THIRD_MATCHED_BONUS_COUNT) {
            return LottoResult.THIRD;
        }
        if (lottoNumbersCount == Constant.SECOND_MATCHED_NUMBER_COUNT
                && bonusNumberCount == Constant.SECOND_MATCHED_BONUS_COUNT) {
            return LottoResult.SECOND;
        }
        if (lottoNumbersCount == Constant.FIRST_MATCHED_NUMBER_COUNT) {
            return LottoResult.FIRST;
        }
        return LottoResult.ERROR;
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
