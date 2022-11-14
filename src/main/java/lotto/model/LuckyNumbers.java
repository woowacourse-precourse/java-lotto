package lotto.model;

import static lotto.utils.ExceptionMessage.BONUS_NUMBER_OVERLAP_EXCEPTION;
import static lotto.utils.ExceptionMessage.LOTTO_NUMBERS_RANGE_EXCEPTION;

public class LuckyNumbers {
    private final Lotto luckyNumbers;
    private final int bonusNumber;

    public LuckyNumbers(Lotto luckyNumbers, int bonusNumber) {
       validateLuckyNumbers(luckyNumbers,bonusNumber);
        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;

    }
    private void validateLuckyNumbers(Lotto luckyNumbers, int bonusNumber){
        validateLuckyNumbersDistinctBonusNumber(luckyNumbers,bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }
    private void validateLuckyNumbersDistinctBonusNumber(Lotto luckyNumbers, int bonusNumber){
        if(luckyNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(BONUS_NUMBER_OVERLAP_EXCEPTION);
        }
    }
    private void validateBonusNumberRange(int bonusNumber){
        if(bonusNumber>45||bonusNumber<1){
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_EXCEPTION);
        }
    }

}
