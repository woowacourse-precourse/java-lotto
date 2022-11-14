package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.utils.Constants;
import lotto.utils.ValidateUtils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        validate(tmpNumbers);
        sortNumber(tmpNumbers);
        this.numbers = tmpNumbers;
    }

    private void sortNumber(List<Integer> list){
        Collections.sort(list);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumbersRange(numbers);
        validateContainDuplicateNumber(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers){
        if (ValidateUtils.isInvalidLottoNumberLength(numbers)) {
            ValidateUtils.throwIllegalArgumentException(Constants.INCORRECT_LOTTO_NUMBER_LENGTH_MESSAGE);
        }
    }

    private void validateNumbersRange(List<Integer> numbers){
        if(ValidateUtils.isNumbersRangeOver(numbers)){
            ValidateUtils.throwIllegalArgumentException(Constants.RANGE_OVER_LOTTO_NUMBER_MESSAGE);
        }
    }

    private void validateContainDuplicateNumber(List<Integer> numbers){
        if(ValidateUtils.isContainDuplicatedNumber(numbers)){
            ValidateUtils.throwIllegalArgumentException(Constants.DUPLICATED_LOTTO_NUMBER_MESSAGE);
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
