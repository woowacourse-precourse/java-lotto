package lotto.validator;

import lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationInDomain {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int THOUSAND = 1000;

    public void checkDividedByThousand(int value){
        if(value % THOUSAND != 0){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DOES_NOT_DIVIDED_BY_THOUSAND);
        }
    }

    public void checkNumbersDuplication(List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>();
        for (int number : numbers){
            if(validator.contains(number)){
                throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_DUPLICATED_NUMBER);
            }
            validator.add(number);
        }
    }

    public void checkNumberRange(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_EXCEEDS_NORMAL_RANGE);
        }
    }

    public void checkNumbersRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < MIN_NUMBER || number > MAX_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.NUMBER_EXCEEDS_NORMAL_RANGE);
            }
        }
    }

    public void checkBonusNumberDuplication(List<Integer> numbers, int bonusNumber){
        Set<Integer> validator = new HashSet<>(numbers);
        if(validator.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_DUPLICATED_NUMBER);
        }
    }

    public void checkNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_NUMBERS_DOES_NOT_MATCH);
        }
    }

    public void checkNegativeNumber(int number){
        if(number < 0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_NEGATIVE_NUMBER_OR_ZERO);
        }
    }

    public void checkZero(int number){
        if(number == 0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_NEGATIVE_NUMBER_OR_ZERO);
        }
    }
}
