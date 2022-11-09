package lotto;

import static lotto.ErrorMessage.*;
import static lotto.LottoGenerator.COUNT;
import static lotto.LottoGenerator.END_INCLUSIVE;
import static lotto.LottoGenerator.START_INCLUSIVE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());

    private LottoValidator(){}

    public static void validate(List<Integer> numbers){
        checkSize(numbers);
    }

    private static void checkSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(COMMON_MESSAGE + LOTTE_SIZE_ERROR.getMessage() + numbers.size());
        }
    }
}
