package lotto;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lottoNumbers) {
        validate(bonusNumber, lottoNumbers);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String number, Lotto lottoNumbers) {
        if (isStringEmpty(number)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        } else if (isSeparatorChar(number)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_IS_SEPARATE_CHAR.getMessage());
        } else if (!isDigit(number) || !isBetweenLottoRange(convertStringToInt(number))) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        } else if (isNumberInLotto(convertStringToInt(number), lottoNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_DUPLICATE_VALUE.getMessage());
        }
    }

    private boolean isStringEmpty(String number) {
        return number == null || number.isBlank();
    }

    private boolean isSeparatorChar(String number) {
        return number.contains(COMMA) || number.contains(SPACE);
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private boolean isBetweenLottoRange(int number) {
        return number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER;
    }

    private int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    private boolean isNumberInLotto(int number, Lotto lottoNumbers) {
        return lottoNumbers.getNumbers().contains(number);
    }
}
