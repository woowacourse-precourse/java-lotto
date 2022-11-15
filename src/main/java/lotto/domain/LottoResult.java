package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final String LOTTO_LENGTH_ERR_MESSAGE = "[ERROR] 로또의 개수가 올바르지 않습니다.";
    private static final String LOTTO_RANGE_ERR_MESSAGE = "[ERROR] 로또의 범위가 올바르지 않습니다.";
    private static final String LOTTO_DUPLICATION_ERR_MESSAGE = "[ERROR] 로또에 중복이 존재합니다.";
    private static final String BONUS_DUPLICATION_ERR_MESSAGE = "[ERROR] 보너스 번호가 당첨번호에 이미 존재합니다.";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean validRange = numbers.stream().allMatch(num -> num >= LOTTO_NUMBER_MIN && num <= LOTTO_NUMBER_MAX);

        if (!validRange) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_ERR_MESSAGE);
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        boolean isContain = winningNumbers.contains(bonusNumber);

        if (isContain) {
            throw new IllegalArgumentException(BONUS_DUPLICATION_ERR_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}