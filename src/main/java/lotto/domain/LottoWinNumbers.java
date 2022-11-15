package lotto.domain;

import java.util.List;

import lotto.utils.Constants;
import lotto.utils.ValidateUtils;

public class LottoWinNumbers extends Lotto{
    private int bonus;

    public LottoWinNumbers(List<Integer> numbers){
        super(numbers);
    }

    public void setBonus(int bonus){
        validateBonus(bonus);
        this.bonus = bonus;
    }

    public int getBonus(){
        return this.bonus;
    }

    private void validateBonus(int bonus){
        validateDuplicatedBonus(bonus);
        validateBonusNumberRange(bonus);
    }

    private void validateDuplicatedBonus(int bonus){
        if(this.getNumbers().contains(bonus)){
            ValidateUtils.throwIllegalArgumentException(Constants.DUPLICATED_LOTTO_NUMBER_MESSAGE);
        }
    }

    private void validateBonusNumberRange(int bonus){
        if(ValidateUtils.isNumberRangeOver(bonus)){
            ValidateUtils.throwIllegalArgumentException(Constants.RANGE_OVER_LOTTO_NUMBER_MESSAGE);
        }
    }
}
