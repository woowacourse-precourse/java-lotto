package lotto.utils;

import static lotto.domain.ErrorMessage.COMMON_MESSAGE;
import static lotto.domain.ErrorMessage.DIVIDE_COMMAS_NOT_EXIST;
import static lotto.domain.ErrorMessage.LOTTE_NUMBER_DUPLICATION;
import static lotto.domain.ErrorMessage.LOTTE_NUMBER_NOT_ASC;
import static lotto.domain.ErrorMessage.LOTTE_NUMBER_OUT_BOUND;
import static lotto.domain.ErrorMessage.LOTTE_SIZE_INVALID;
import static lotto.domain.FirstPlace.DIVIDE_POINT;
import static lotto.utils.InputValidator.NUMBER_REG_EXP;
import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());

    private LottoValidator(){}

    public static void validateLotto(List<Integer> numbers){
        checkSize(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        checkSortedAsc(numbers);
    }

    private static void checkSize(List<Integer> numbers) throws IllegalArgumentException {
        if (COUNT != numbers.size()) {
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

    public static void validateFirstPlace(String firstPlace) {
        checkConsistOfOnlyCommas(firstPlace);
    }

    private static void checkConsistOfOnlyCommas(String firstPlace) {
        Set<String> commasCheck = Arrays.stream(firstPlace.split("")).collect(Collectors.toSet());
        if (!commasCheck.remove(DIVIDE_POINT)) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + DIVIDE_COMMAS_NOT_EXIST.getMessage());
        }
        checkOnlyCommas(commasCheck);
    }

    private static void checkOnlyCommas(Set<String> commasCheck) {
        commasCheck.stream().filter(number -> !number.matches(NUMBER_REG_EXP)).forEach(number -> {
            throw new IllegalArgumentException();
        });
    }

}
