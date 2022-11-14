package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.constant.RegularExpression;

public class WinningLotto {
    private final Lotto lottoWithWinning;
    private final int bonusNumber;

    public WinningLotto(Lotto lottoWithWinning, int bonusNumber) {
        validateRangeOfNumber(bonusNumber);
        validateBonusNumberAndLottoAreDuplicate(lottoWithWinning, bonusNumber);

        this.lottoWithWinning = lottoWithWinning;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lottoWithWinning, String bonusNumber) {
        validateStringIsNumeric(bonusNumber);
        int bonusNumberParseInt = Integer.parseInt(bonusNumber);
        validateRangeOfNumber(bonusNumberParseInt);
        validateBonusNumberAndLottoAreDuplicate(lottoWithWinning, bonusNumberParseInt);

        this.lottoWithWinning = lottoWithWinning;
        this.bonusNumber = bonusNumberParseInt;
    }

    private void validateStringIsNumeric(String userInput) {
        if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), userInput)) {
            throw new IllegalArgumentException(ErrorMessage.THIS_INPUT_ALLOW_NUMBER.getMessage());
        }
    }

    private void validateRangeOfNumber(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusNumberAndLottoAreDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_AND_WINNING_LOTTO_NUMBERS_ARE_DUPLICATE.getMessage()
            );
        }
    }

    private boolean isInRange(int number) {
        return LottoNumber.START_NUMBER_OF_LOTTO.getNumber() <= number
                && number <= LottoNumber.END_NUMBER_OF_LOTTO.getNumber();
    }

    public List<Integer> getWinningNumbers() {
        return lottoWithWinning.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
