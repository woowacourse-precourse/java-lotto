package ui;

import java.util.List;
import java.util.stream.Collectors;

import static values.Message.Error.*;

public class LottoUi {

    public static void validate(List<Integer> numbers){
        validateNumbersSize(numbers);
        validateDuplication(numbers);
        validateNumbersRange(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private static void validateDuplication(List<Integer> numbers){
        List<Integer> duplicationRemoved = numbers.stream().distinct().collect(Collectors.toList());

        if(duplicationRemoved.size() != 6){
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers){
        numbers.forEach(num -> {
            if(!(num >= 1 && num <=45)){
                throw new IllegalArgumentException(RANGE_ERROR);
            }
        });
    }
}
