package lotto.utils;

import lotto.constant.Constant;

import java.util.Arrays;
import java.util.List;

public class Validation {
    public static final String LOTTO_MUST_THOUSAND_PRICE = "[ERROR] 구매금액은 1000원 단위여야 합니다.";
    public static final String LOTTO_INPUT_MUST_NUMBER = "[ERROR] 구매금액은 숫자여야만 합니다.";
    public static final String LOTTO_NUMBER_IS_SIX = "[ERROR] 로또의 발행번호는 총 6개여야 합니다. (보너스 제외)";
    public static final String LOTTO_NUMBER_IS_DISTINCT = "[ERROR] 로또의 발행번호들은 중복되지 않아야합니다.";
    public static final String FIRST_NUMBER_IS_NOT_ZERO = "[ERROR] 로또구입 금액이 2자리수가 넘어가면, 맨 앞자리가 0이 될 수 없습니다.";
    public static final String LOTTO_NUMBER_IN_RANGE = "[ERROR] 로또의 번호는 1~45 사이의 값입니다.";
    public static final String BONUS_DISTINCT_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다.";

    public static void validateCheckNumeric(String input, String regex) {
        String[] split = input.split(regex);

        if (!Arrays.stream(split).allMatch(number -> number.charAt(0) >= '0' && number.charAt(0) <= '9'))
            throw new IllegalArgumentException(LOTTO_INPUT_MUST_NUMBER);
    }

    public static void validateFirstNumberIsNotZero(String input) {
        String[] split = input.split(Constant.SPLIT_FOR_MONEY);

        if (split.length > 1 && split[0].equals("0"))
            throw new IllegalArgumentException(FIRST_NUMBER_IS_NOT_ZERO);
    }

    public static void validateNumberInRange(String input) {
        int result = Integer.parseInt(input);
        if (result < Constant.LOTTO_MIN_NUMBER || result > Constant.LOTTO_MAX_NUMBER)
            throw new IllegalArgumentException(LOTTO_NUMBER_IN_RANGE);
    }

    public static void checkThousandMoney(String input) {
        int price = Integer.parseInt(input);

        if (price % Constant.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(LOTTO_MUST_THOUSAND_PRICE);
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_SIX);
        }
    }

    public static void validateIsDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_DISTINCT);
        }
    }

    public static void validNumberInRange(List<Integer> numbers) {
        boolean inRange = numbers.stream().allMatch(number -> number >= Constant.LOTTO_MIN_NUMBER && number <= Constant.LOTTO_MAX_NUMBER);

        if (inRange == false)
            throw new IllegalArgumentException(LOTTO_NUMBER_IN_RANGE);
    }

    public static void validateDistinctInBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_DISTINCT_WINNING_NUMBER);
    }
}
