package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constValue.Constants.ExceptionMessage.BONUS_NUMBER_BAD_FORMAT_ERROR_MESSAGE;
import static lotto.constValue.Constants.ExceptionMessage.BONUS_NUMBER_OVER_RANGE_ERROR_MESSAGE;
import static lotto.constValue.Constants.Format.BONUS_NUMBER_FORMAT;
import static lotto.constValue.Constants.LottoInfo.MAX_RANGE;
import static lotto.constValue.Constants.LottoInfo.MIN_RANGE;

public class Bonus {

    private int bonusNumber;

    public Bonus(String bonusNumber) {
        validateBonus(bonusNumber);
        this.bonusNumber = getParseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static int getParseInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public void validateBonus(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateBonusRange(bonusNumber);
    }

    public void validateBonusRange(String bonusNumber) {
        int bonus = getParseInt(bonusNumber);
        if (bonus >= MIN_RANGE && bonus <= MAX_RANGE) {
            return;
        }
        throw new IllegalArgumentException(BONUS_NUMBER_OVER_RANGE_ERROR_MESSAGE);
    }

    public void validateBonusNumber(String bonusNumber) {
        if (isBonusNumber(bonusNumber)) {
            return;
        }
        throw new IllegalArgumentException(BONUS_NUMBER_BAD_FORMAT_ERROR_MESSAGE);
    }

    public boolean isBonusNumber(String bonusNumber) {
        boolean found = false;

        String regex = BONUS_NUMBER_FORMAT;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bonusNumber);
        if (matcher.matches()) {
            found = true;
        }
        return found;
    }
}
