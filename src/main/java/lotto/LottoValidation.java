package lotto;

import java.util.List;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class LottoValidation {

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(NOT_LOTTO_LENGTH);
            throw new IllegalArgumentException(NOT_LOTTO_LENGTH);
        }
    }

    public static void validLottoNumberDuplicate(List<Integer> numbers) {
        long delDuplicateSize = numbers.stream().distinct().count();
        if (numbers.size() != delDuplicateSize) {
            System.out.println(DUPLICATE_LOTTO_NUMBER);
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    public static void validNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .noneMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX);
        if (!isValid) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validNumberRange(int num) {;
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }

    public static boolean validIsDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
