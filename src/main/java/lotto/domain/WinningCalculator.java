package lotto.domain;

import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.END_NUMBER;
import static lotto.constant.LottoRule.START_NUMBER;
import static lotto.constant.WinningResult.RANK_1;
import static lotto.constant.WinningResult.RANK_2;
import static lotto.constant.WinningResult.RANK_3;
import static lotto.constant.WinningResult.RANK_4;
import static lotto.constant.WinningResult.RANK_5;
import static lotto.constant.WinningResult.RANK_NONE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.WinningResult;

public class WinningCalculator {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<Integer, WinningResult> winningTable = new HashMap<>();

    public WinningCalculator() {
        this.winningTable.put(0, RANK_NONE);
        this.winningTable.put(1, RANK_NONE);
        this.winningTable.put(2, RANK_NONE);
        this.winningTable.put(3, RANK_5);
        this.winningTable.put(4, RANK_4);
        this.winningTable.put(5, RANK_3);
        this.winningTable.put(6, RANK_1);
    }

    public void setWinningNumbers(String numbersRaw) {
        validateNumbersRaw(numbersRaw);
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(String bonusNumberRaw) {
        validateBonusNumberRaw(bonusNumberRaw);
        int bonusNumber = Integer.parseInt(bonusNumberRaw);
        this.bonusNumber = bonusNumber;
    }

    public WinningResult getResultOfOneLotto(Lotto lotto) {
        int countContainWinningNumbers = calculateCountContainWinningNumbers(lotto);
        boolean isContainBonusNumber = checkIsContainBonusNumber(lotto);
        WinningResult winningResult = matchWinningResult(countContainWinningNumbers, isContainBonusNumber);
        return winningResult;
    }

    private List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }

    private int calculateCountContainWinningNumbers(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        int count = 0;
        for (int number : numbersOfLotto) {
            if (this.winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkIsContainBonusNumber(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        boolean isContainBonusNumber = numbersOfLotto.contains(this.bonusNumber);
        return isContainBonusNumber;
    }

    private WinningResult matchWinningResult(int countContainNumbers, boolean isContainBonusNumber) {
        WinningResult winningResult = this.winningTable.get(countContainNumbers);
        if ((winningResult == RANK_3) && isContainBonusNumber) {
            winningResult = RANK_2;
        }
        return winningResult;
    }

    private void validateNumbersRaw(String numbersRaw) {
        try {
            List<Integer> numbers = convertStringToIntegerList(numbersRaw);
            validateNumbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_TOO_BIG);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        validateLengthOfNumbers(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicationOfNumbers(numbers);
    }

    private void validateLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() == COUNT_OF_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INCORRECT_COUNT);
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (START_NUMBER <= number && number <= END_NUMBER) {
                continue;
            }
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INCORRECT_RANGE);
        }
    }

    private void validateDuplicationOfNumbers(List<Integer> numbers) {
        Set<Integer> numbersDeletedDuplication = new HashSet<>(numbers);
        if (numbers.size() == numbersDeletedDuplication.size()) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATED);
    }

    private void validateBonusNumberRaw(String bonusNumberRaw) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberRaw);
            validateRangeOfBonusNumber(bonusNumber);
            validateBonusNumberAlreadyInWinningNumbers(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_TOO_BIG);
        }
    }

    private void validateRangeOfBonusNumber(int bonusNumber) {
        if (START_NUMBER <= bonusNumber && bonusNumber <= END_NUMBER) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INCORRECT_RANGE);
    }

    private void validateBonusNumberAlreadyInWinningNumbers(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ALREADY_IN_WINNING_NUMBERS);
        }
    }
}
