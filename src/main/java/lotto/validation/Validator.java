package lotto.validation;

import lotto.domain.WinningLotto;

import java.util.List;

import static lotto.util.Constants.*;

public class Validator {

    public static void validateStringIsNumeric(String input){
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public static void validatePriceRange(int price){
        if(price < 0) {
            throw new IllegalArgumentException(INPUT_IS_NEGATIVE_NUMBER);
        }
    }

    public static void validateUnit(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException(INVALID_MONETARY_UNIT);
        }
    }

    public static void validateSize(List<Integer> list, int size){
        if(list.size() != size){
            throw new IllegalArgumentException(String.format(INVALID_SIZE, size));
        }
    }

    public static void validateNumbersRange(List<Integer> numbers, int startRange, int endRange){
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(int number){
        if(number < LOTTO_START_RANGE || number > LOTTO_END_RANGE){
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public static void validateNonDuplicatedList(List<Integer> lst){
        if(lst.size() != lst.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATED_NUMBER_LIST);
        }
    }

    public static void validateNonDuplicatedBonusNumber(WinningLotto winningLotto, int bonus) {
        if(winningLotto.contains(bonus)){
            throw new IllegalArgumentException(DUPLICATED_WITH_WINNING_NUMBER);
        }
    }
}
