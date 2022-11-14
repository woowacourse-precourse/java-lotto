package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_OUT_BOUND;
import static lotto.domain.model.ErrorMessage.LOTTE_NUMBER_DUPLICATION;
import static lotto.domain.model.ErrorMessage.LOTTE_SIZE_INVALID;
import static lotto.domain.model.ErrorMessage.NOT_DIVIDE_COMMAS;
import static lotto.domain.model.ErrorMessage.getErrorMessage;
import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class LottoValidator{

    public static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());
    private static final String FIRST_PLACE_REG_EXP =
            "([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})\\,([0-9]{1,2})";


    public static void checkSize(final List<Integer> numbers){
        if (COUNT != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_SIZE_INVALID) + numbers.size());
        }
    }

    public static void checkDuplication(final List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();
        Set<Integer> duplications = numbers.stream()
                .filter(number -> !check.add(number))
                .collect(Collectors.toSet());
        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(LOTTE_NUMBER_DUPLICATION, duplications));
        }
    }

    public static void checkRange(final List<Integer> numbers) {
        Set<Integer> outBound = numbers.stream()
                .filter(number -> !STANDARD_LOTTO_NUMBER.contains(number))
                .collect(Collectors.toSet());
        if (outBound.size() != 0) {
            throw new IllegalArgumentException(getErrorMessage(BONUS_NUMBER_OUT_BOUND, outBound));
        }
    }


    public static void checkConsistOfOnlyCommas(final String firstPlace) {
        if (!firstPlace.matches(FIRST_PLACE_REG_EXP))
            throw new IllegalArgumentException(getErrorMessage(NOT_DIVIDE_COMMAS));
    }
}
