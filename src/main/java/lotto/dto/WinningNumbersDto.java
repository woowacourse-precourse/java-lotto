package lotto.dto;

import lotto.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbersDto {
    private static final int LOTTO_COUNT = 6;
    private static final String DELIMITER = ",";
    private static final String NUMBER_PATTERN = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";    // 1 ~ 45
    private static final String DELIMITER_FORM_EXCEPTION_MESSAGE = "당첨 번호는 콤마(,)로 구분해야 합니다.";
    private static final String SIZE_EXCEPTION_MESSAGE = "당첨 번호는 중복없는 6개의 값이어야 합니다.";
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "당첨 번호는 1 ~ 45 사이 숫자여야 합니다.";
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";

    private List<Integer> winningNumbers;

    public WinningNumbersDto(String winningNumbers) {
        this(parseWinningNumbers(winningNumbers));
    }

    public WinningNumbersDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        validate(winningNumbers);
        return Arrays.stream(winningNumbers.split(","))
                .map(number -> Integer.parseInt(number)).collect(Collectors.toList());
    }

    private static void validate(final String winningNumbers) {
        validateDelimiter(winningNumbers);
        validateDuplicateAndSize(winningNumbers);
        validateNumbers(winningNumbers);
    }

    private static void validateNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER);

        for (String number : numbers) {
            validateBlank(number);
            validateNumber(number);
        }
    }

    private static void validateNumber(String number) {
        if (!Pattern.matches(NUMBER_PATTERN, number)) {
            throw new IllegalArgumentException(NUMBER_FORM_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBlank(String number) {
        if (StringUtils.isBlank(number)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDuplicateAndSize(String winningNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(winningNumbers.split(DELIMITER)));

        if (uniqueNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDelimiter(final String winningNumbers) {
        if (!winningNumbers.contains(DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_FORM_EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
