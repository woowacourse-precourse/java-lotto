package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_DUPLICATION;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_NOT_ASC;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_OUT_BOUND;
import static lotto.domain.model.ErrorMessage.LOTTE_SIZE_INVALID;
import static lotto.domain.model.ErrorMessage.NOT_DIVIDE_COMMAS;
import static lotto.domain.model.ErrorMessage.getErrorMessage;
import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

    public static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());
    private static final String FIRST_PLACE_REG_EXP =
            "([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})";

    private LottoValidator() {
    }

    public static void checkSize(List<Integer> numbers){
        if (COUNT != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_SIZE_INVALID) + numbers.size());
        }
    }

    public static void checkDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_NUMBER_DUPLICATION));
        }
    }

    public static void checkRange(List<Integer> numbers) {
        numbers.stream().filter(number -> !STANDARD_LOTTO_NUMBER.contains(number)).forEach(number -> {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_NUMBER_OUT_BOUND));
        });
    }

    public static void checkSortedAsc(List<Integer> numbers) {
        IntStream.range(0, numbers.size() - 1).filter(i -> numbers.get(i) > numbers.get(i + 1)).forEachOrdered(i -> {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_NUMBER_NOT_ASC));
        });
    }

    public static void checkConsistOfOnlyCommas(String firstPlace) {
        if (!firstPlace.matches(FIRST_PLACE_REG_EXP))
            throw new IllegalArgumentException(getErrorMessage(NOT_DIVIDE_COMMAS));
    }
}
