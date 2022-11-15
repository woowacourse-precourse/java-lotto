package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static String ERROR_NUMBERS_SIZE = "로또 번호의 개수가 올바르지 않습니다.";
    private static String ERROR_NUMBERS_UNIQUE = "로또 번호는 중복을 허용하지 않습니다.";
    private static String ERROR_NUMBERS_RANGE = "로또 번호의 범위가 올바르지 않습니다.";
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRangeOfNumber(numbers);
        validateUnique(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException(ERROR_NUMBERS_SIZE);
        }
    }

    private void validateUnique(List<Integer> numbers){
        List<Integer> checkUnique = new ArrayList<>();
        for(int number: numbers){
            if(checkUnique.contains(number)){
                throw new IllegalArgumentException(ERROR_NUMBERS_UNIQUE);
            }
            checkUnique.add(number);
        }
    }

    private void validateRangeOfNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_NUMBERS_RANGE);
            }
        }
    }
}
