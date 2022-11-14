package lotto;

import lotto.domain.LottoValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String INVALID_MONEY_MESSAGE = "구입 금액은 " + LottoValue.ONE_LOTTO_PRICE.getValue() + "원 단위로만 입력 가능합니다.";
    private final static String INVALID_TYPE_MESSAGE = "숫자만 입력 가능합니다.";
    private final static String INVALID_LENGTH_MESSAGE = LottoValue.LOTTO_LENGTH.getValue() + "개의 숫자여야 합니다.";
    private final static String DUPLICATE_MESSAGE = "로또에는 중복된 숫자가 들어갈 수 없습니다.";
    private final static String INVALID_NUMBER_RANGE = "로또 번호는 " + LottoValue.START_LOTTO_NUMBER.getValue() + "부터 " + LottoValue.END_LOTTO_NUMBER.getValue() + " 사이의 숫자여야 합니다.";
    private final static String DUPLICATE_BONUS_MESSAGE = "당첨 번호와 중복되지 않는 숫자를 입력해주세요.";

    public static void isNumberType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_TYPE_MESSAGE);
        }
    }

    public static void isDividedByThousand(int value) {
        if (value == 0 || value % LottoValue.ONE_LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_MESSAGE);
        }
    }

    public static void isNumberList(List<String> input) {
        for (String value : input) {
            isNumberType(value);
        }
    }

    public static void isValidLength(List<String> numbers) {
        if (numbers.size() != LottoValue.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_LENGTH_MESSAGE);
        }
    }

    public static void isContainDuplicateNumber(List<String> value) {
        Set<String> listSet = new HashSet<>(value);
        if (listSet.size() != LottoValue.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_MESSAGE);
        }
    }

    public static void isValidNumberRange(List<String> value) {
        int number;
        for (int i = 0; i < LottoValue.LOTTO_LENGTH.getValue(); i++) {
            number = Integer.parseInt(value.get(i));
            isValidRange(number);
        }
    }

    public static void isValidRange(int number) {
        if (number < LottoValue.START_LOTTO_NUMBER.getValue() || number > LottoValue.END_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_RANGE);
        }
    }

    public static void isContainDuplicateNumberByPrize(int bonus, List<Integer> prizeNumbers) {
        List<Integer> prizeAddBonus = new ArrayList<>(prizeNumbers);
        prizeAddBonus.add(bonus);

        Set<Integer> listSet = new HashSet<>(prizeAddBonus);
        if (listSet.size() == LottoValue.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_BONUS_MESSAGE);
        }
    }

    public static void validateMoneyInput(String moneyInput) {
        isNumberType(moneyInput);
        int money = Integer.parseInt(moneyInput);
        isDividedByThousand(money);
    }

    public static void validatePrizeNumberInput(List<String> prizeNumberInput) {
        isNumberList(prizeNumberInput);
        isValidLength(prizeNumberInput);
        isValidNumberRange(prizeNumberInput);
        isContainDuplicateNumber(prizeNumberInput);
    }

    public static void validateBonusInput(String bonusInput, List<Integer> prizeNumbers) {
        isNumberType(bonusInput);
        isValidRange(Integer.parseInt(bonusInput));
        isContainDuplicateNumberByPrize(Integer.parseInt(bonusInput), prizeNumbers);
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        List<String> stringNumbers = new ArrayList<>();
        for (int number : numbers) {
            stringNumbers.add(Integer.toString(number));
        }

        isValidLength(stringNumbers);
        isContainDuplicateNumber(stringNumbers);
        for (int number : numbers) {
            isValidRange(number);
        }
    }
}