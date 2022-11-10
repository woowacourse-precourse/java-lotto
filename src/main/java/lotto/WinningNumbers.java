package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
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
        List<Integer> winningNumbers = convertNumbers();
        this.winningNumbers = winningNumbers;

        printGuideMessage(GuideMessageType.BONUS_NUMBER.message);
        int bonusNumber = Integer.parseInt(setNumber());
        this.bonusNumber = bonusNumber;
    }

    private String setNumber() {
        return Console.readLine();
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
        return stringToInt(arrayToList(splitNumbers(setNumber())));
    }
}
