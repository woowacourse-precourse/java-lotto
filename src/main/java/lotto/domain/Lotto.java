package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ConstValue.LottoConst;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LottoNumberValidator.validate;
import static lotto.exception.ExceptionType.*;
import static lotto.util.ConstValue.LottoConst.LOTTO_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        final List<Integer> lottoNumber =
                Randoms.pickUniqueNumbersInRange(LottoConst.START_NUMBER, LottoConst.END_NUMBER, LottoConst.LOTTO_LENGTH);
        List<Integer> sortedLottoNumber = new ArrayList<>(lottoNumber);
        sortedLottoNumber.sort(Integer::compareTo);
        return new Lotto(sortedLottoNumber);
    }

    public enum LottoNumberValidator {

        LOTTO_NUMBER_SIZE((List<Integer> numbers) -> {
            if (numbers.size() != LOTTO_LENGTH) {
                throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR.getMessage());
            }
        }),

        LOTTO_NUMBER_DISTINCT((List<Integer> numbers) -> {
            final int distinctListSize = (int) numbers.stream().distinct().count();
            if (numbers.size() != distinctListSize) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
            }
        }),

        LOTTO_NUMBER_RANGE((List<Integer> numbers) -> {
            final List<Integer> outOfRangeNumbers = numbers.stream()
                    .filter(LottoNumberValidator::isLottoNumberOutOfRange)
                    .collect(Collectors.toList());
            if (outOfRangeNumbers.size() > 0) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage() +
                        "\n잘못된 숫자 : " + outOfRangeNumbers.stream().map(String::valueOf)
                        .collect(Collectors.joining(","))
                );
            }
        });

        private final Validator<List<Integer>> validator;

        LottoNumberValidator(final Validator<List<Integer>> validator) {
            this.validator = validator;
        }

        public static void validate(final List<Integer> numbers) {
            Arrays.stream(values()).forEach(v -> v.validator.validate(numbers));
        }

        public static boolean isLottoNumberOutOfRange(final int number) {
            return number < LottoConst.START_NUMBER || number > LottoConst.END_NUMBER;
        }
    }
}
