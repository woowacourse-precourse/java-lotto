package lotto.input;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(String input) {
        validate(input);
        winningNumbers = inputStringToList(input);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private static List<Integer> inputStringToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }

    public void validate(String input) {
        isCommaCorrect(input);
        isSizeOfSix(input);
        isAllNumber(input);
    }

    private void isCommaCorrect(String input) {
        if (! input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 콤마(',')로 숫자를 이어서 입력해야 합니다.");
        }
    }

    private void isSizeOfSix(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private void isAllNumber(String input) {
        String[] inputs = input.split(",");
        for (String digits : inputs) {
            try {
                Integer.valueOf(digits);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }
}
