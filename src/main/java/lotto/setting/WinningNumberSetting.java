package lotto.setting;

import java.util.List;
import java.util.stream.Stream;

public enum WinningNumberSetting {
    NORMAL(45, 6, 1);

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER;
    private final int NUMBER_OF_DRAWS;
    private final int BONUS_DRAWS;

    WinningNumberSetting(int maxNumber, int numberOfDraws, int bonusDraws) {
        this.MAX_NUMBER = maxNumber;
        this.NUMBER_OF_DRAWS = numberOfDraws;
        this.BONUS_DRAWS = bonusDraws;
    }

    public boolean isValidateNumbers(List<Integer> numbers, List<Integer> bonusNumbers) {
        return isSizeCorrect(numbers, bonusNumbers) &&
                isNumberInRange(numbers, bonusNumbers) &&
                isNotOverlapped(numbers, bonusNumbers);
    }

    private boolean isSizeCorrect(List<Integer> numbers, List<Integer> bonusNumbers) {
        return numbers.size() == NUMBER_OF_DRAWS && bonusNumbers.size() == BONUS_DRAWS;
    }

    private boolean isNumberInRange(List<Integer> numbers, List<Integer> bonusNumbers) {
        return Stream.concat(numbers.stream(), bonusNumbers.stream())
                .map(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean isNotOverlapped(List<Integer> numbers, List<Integer> bonusNumbers) {
        return Stream.concat(numbers.stream(), bonusNumbers.stream())
                .distinct().count() == NUMBER_OF_DRAWS + BONUS_DRAWS;
    }
}
