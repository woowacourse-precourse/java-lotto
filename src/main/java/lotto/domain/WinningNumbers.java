package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String input) {
        validate(input);
        this.winningNumbers = new Lotto(convertToNumbers(input));
    }

    private void validate(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreTokens()) {
            isNumber(tokenizer.nextToken());
        }
    }

    private static void isNumber(String token) {
        try {
            int nowToken = Integer.parseInt(token);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertToNumbers(String input) {
        List<Integer> convertedInput = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreTokens()) {
            int nextNumber = Integer.parseInt(tokenizer.nextToken());
            convertedInput.add(nextNumber);
        }
        return convertedInput;
    }

    public void chooseBonusNumber(String input) {
        isNumber(input);
        isInRange(input);
        isDuplicated(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void isInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(String input) {
        int number = Integer.parseInt(input);
        if (winningNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> winningNumbers() {
        return winningNumbers.lottoNumbers();
    }

    public int bonusNumber() {
        int bonusResult = this.bonusNumber;
        return bonusResult;
    }
}
