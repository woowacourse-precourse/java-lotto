package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProvidNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public ProvidNumber(String winningNumbers, String bonusNumber) {
        validateWinningNumbersOnlyNumberAndComma(winningNumbers);
        validateBonusNumber(bonusNumber);

        this.winningNumbers = new Lotto(numberAndCommaToOnlyNumber(winningNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);

        validateBonusNumberDuplicateWinningNumber();
    }

    private void validateWinningNumbersOnlyNumberAndComma(String winningNumbers) {
        for (int i = 0; i < winningNumbers.length(); i++) {
            if ((winningNumbers.charAt(i) < '0' || winningNumbers.charAt(i) > '9') && winningNumbers.charAt(i) != ',') {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ONLY_NUMBER_AND_COMMA.getErrorMessage());
            }
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        validateBonusNumberOnlyNumber(bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberOnlyNumber(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (bonusNumber.charAt(i) < '0' || bonusNumber.charAt(i) >'9') {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ONLY_NUMBER.getErrorMessage());
            }
        }
    }

    private void validateBonusNumberRange(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getErrorMessage());
        }
    }




    private List<Integer> numberAndCommaToOnlyNumber(String winningNumbers) {
        List<Integer> numbers = Stream.of(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return numbers;
    }

    private void validateBonusNumberDuplicateWinningNumber() {
        List<Integer> numbers = getWinningNumbers().getNumbers();
        int bonusNumber = getBonusNumber();

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getErrorMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
