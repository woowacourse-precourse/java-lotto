package lotto.utils;

import static lotto.domain.ErrorMessage.*;
import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());

    private LottoValidator(){}

    public static void validate(List<Integer> numbers){
        checkSize(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        checkSortedAsc(numbers);
    }

    private static void checkSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_SIZE_INVALID.getMessage() + numbers.size());
        }
    }

    private static void checkDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_DUPLICATION.getMessage());
        }
    }

    private static void checkRange(List<Integer> numbers) {
        numbers.stream().filter(number -> !STANDARD_LOTTO_NUMBER.contains(number)).forEach(number -> {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_OUT_BOUND.getMessage());
        });
    }

    private static void checkSortedAsc(List<Integer> numbers) {
        IntStream.range(0, numbers.size() - 1).filter(i -> numbers.get(i) > numbers.get(i + 1)).forEachOrdered(i -> {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_NOT_ASC.getMessage());
        });

    }

}
