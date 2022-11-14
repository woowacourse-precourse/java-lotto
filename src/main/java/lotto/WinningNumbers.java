package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private enum GuideMessageType {
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        GuideMessageType(String message) {
            this.message = message;
        }
    }

    public WinningNumbers() {
        printGuideMessage(GuideMessageType.WINNING_NUMBERS.message);
        this.winningNumbers = convertNumbers();

        printGuideMessage(GuideMessageType.BONUS_NUMBER.message);
        String bonusNumber = setNumber();
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private String setNumber() {
        return Console.readLine();
    }

    private void validateWinningNumbers(List<String> numbers) {
        final String INPUT_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";

        Set<String> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }

        for (String number : numbers) {
            boolean isMatch = Pattern.matches(INPUT_PATTERN, number);

            if (!isMatch) {
                throw new IllegalArgumentException("[ERROR]");
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

    private void printGuideMessage(String message) {
        System.out.println(message);
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

    private List<Integer> convertNumbers() {
        List<String> convertedNumbers = arrayToList(splitNumbers(setNumber()));
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
