package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        this.winningNumbers = convertNumbers(winningNumbers);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateWinningNumbers(List<String> numbers) {
        final String INPUT_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";
        final String SIZE_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자 또는 6개의 숫자가 입력되지 않았습니다.";
        final String RANGE_EXCEPTION_MESSAGE = "1-45를 벗어나는 문자를 입력할 수 업습니다.";

        Set<String> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_DUPLICATE_EXCEPTION_MESSAGE);
        }

        for (String number : numbers) {
            boolean isMatch = Pattern.matches(INPUT_PATTERN, number);

            if (!isMatch) {
                throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private void validateBonusNumber(String number) {
        final String INPUT_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";

        boolean isMatch = Pattern.matches(INPUT_PATTERN, number);

        if (!isMatch) {
            throw new IllegalArgumentException("[ERROR]");
        }

        if (this.winningNumbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private String[] splitNumbers(String numbers) {
        return numbers.split(",");
    }

    private List<String> arrayToList(String[] numbers) {
        return Arrays.asList(numbers);
    }

    private List<Integer> stringToInt(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<Integer> convertNumbers(String numbers) {
        List<String> convertedNumbers = arrayToList(splitNumbers(numbers));
        validateWinningNumbers(convertedNumbers);

        return stringToInt(convertedNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
