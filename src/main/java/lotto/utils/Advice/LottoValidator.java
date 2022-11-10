package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.domain.model.ErrorMessage.NOT_DIVIDE_COMMAS;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_DUPLICATION;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_NOT_ASC;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_OUT_BOUND;
import static lotto.domain.model.ErrorMessage.LOTTE_SIZE_INVALID;
import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());
    private static final String FIRST_PLACE_REG_EXP =
            "([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})";

    private LottoValidator() {
    }

    public static void checkSize(List<Integer> numbers){
        if (COUNT != numbers.size()) {
            throw new IllegalArgumentException(
                    COMMON_MESSAGE.getMessage() + LOTTE_SIZE_INVALID.getMessage() + numbers.size());
        }
    }

    public static void checkDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_DUPLICATION.getMessage());
        }
    }

    public static void checkRange(List<Integer> numbers) {
        numbers.stream().filter(number -> !STANDARD_LOTTO_NUMBER.contains(number)).forEach(number -> {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_OUT_BOUND.getMessage());
        });
    }

    public static void checkSortedAsc(List<Integer> numbers) {
        IntStream.range(0, numbers.size() - 1).filter(i -> numbers.get(i) > numbers.get(i + 1)).forEachOrdered(i -> {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + LOTTE_NUMBER_NOT_ASC.getMessage());
        });
    }

    public static void checkConsistOfOnlyCommas(String firstPlace) {
        if (!firstPlace.matches(FIRST_PLACE_REG_EXP))
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + NOT_DIVIDE_COMMAS.getMessage());
    }
}
