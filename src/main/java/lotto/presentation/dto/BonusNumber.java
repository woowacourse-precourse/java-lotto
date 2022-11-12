package lotto.presentation.dto;

import lotto.support.Validator;

import java.util.List;

public class BonusNumber {
    private static final int NUMBER_OF_DIGIT=1;
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber){
        validate(bonusNumber);
        this.bonusNumber=Integer.parseInt(bonusNumber);
    }
    private void validate(String target){
        Validator.checkInteger(target);
        Validator.checkNumberOfDigit(NUMBER_OF_DIGIT, List.of(Integer.parseInt(target)));
        Validator.checkNumericalRange(List.of(Integer.parseInt(target)));
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
