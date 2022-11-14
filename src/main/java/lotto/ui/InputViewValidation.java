package lotto.ui;

import lotto.lotto.LottoManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputViewValidation {

    static final String ERROR_NOT_INTEGER_FORMAT = "[ERROR] 숫자만 입력해주세요.";
    static final String ERROR_NOT_1000 = "[ERROR] 1000단위 숫자만 입력해주세요.";
    static public final String ERROR_LOTTO_SIZE = "[ERROR] 6개의 당첨 번호를 입력해주세요.";
    static public final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String ERROR_INPUT_FORMAT = "[ERROR] 입력 형식이 지켜지지 않았습니다.";
    static public final String ERROR_DUPLICATE_NUMBER = "[ERROR] 중복된 수가 입력되었습니다.";
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");


    public static void validateIsInteger(String input) {
        if (!NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_FORMAT);
        }
    }

    public static void validateIs1000(String input) {
        if (input.charAt(input.length() - 1) != '0' || input.charAt(input.length() - 2) != '0' || input.charAt(input.length() - 3) != '0') {
            throw new IllegalArgumentException(ERROR_NOT_1000);
        }
    }

    public static void validateWinningNumbersFormat(String input) {
        if (!NUMBER_PATTERN.matcher(String.valueOf(input.charAt(0))).find() ||
                !NUMBER_PATTERN.matcher(String.valueOf(input.charAt(input.length() - 1))).find()) {
            throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
        }
        for (int i = 1; i < input.length() - 1; i++) {
            if (Objects.equals(input.charAt(i), ',')) {
                if (!NUMBER_PATTERN.matcher(String.valueOf(input.charAt(i - 1))).find() || !NUMBER_PATTERN.matcher(String.valueOf(input.charAt(i + 1))).find()) {
                    throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
                }
            }
        }
    }

    public static void validateWinningNumbersSize(String input) {
        String[] winningNumbers = input.split(",");
        if (winningNumbers.length != LottoManager.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    public static void validateWinningNumbersInteger(String input) {
        String[] winningNumbers = input.split(",");
        for (String number : winningNumbers) {
            if (!NUMBER_PATTERN.matcher(number).find()) {
                throw new IllegalArgumentException(ERROR_NOT_INTEGER_FORMAT);
            }
        }
    }

    public static void validateWinningNumbersRange(String input) {
        String[] winningNumbers = input.split(",");
        for (String number : winningNumbers) {
            if (Integer.parseInt(number) > LottoManager.LOTTO_RANGE_END || Integer.parseInt(number) < LottoManager.LOTTO_RANGE_START) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public static void validateWinningNumbersUnique(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        HashSet<Integer> hashSet = new HashSet<>(winningNumbers);
        if (hashSet.size() != LottoManager.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public static void validateBonusNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number > LottoManager.LOTTO_RANGE_END || number < LottoManager.LOTTO_RANGE_START) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
