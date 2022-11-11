package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;
import java.util.HashSet;
import java.util.List;

public class GeneralWinNumber {

    private final List<Integer> generalWinNumbers;

    public GeneralWinNumber(List<Integer> generalWinNumbers) {
        validate(generalWinNumbers);
        this.generalWinNumbers = generalWinNumbers;
    }

    public void validate(List<Integer> generalWinNumbers) {
        if (generalWinNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_SIX_DIGIT);
        }

        if (isWithinRange(generalWinNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.WITHIN_RANGE);
        }

        if (isDuplicateNumber(generalWinNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS);
        }
    }

    private boolean isWithinRange(List<Integer> generalWinNumbers) {
        return generalWinNumbers.stream()
                .anyMatch(number -> number < LottoGame.LOTTO_MIN_RANGE || number > LottoGame.LOTTO_MAX_RANGE);
    }

    private boolean isDuplicateNumber(List<Integer> generalWinNumbers) {
        return new HashSet<>(generalWinNumbers).size() != generalWinNumbers.size();
    }

}
