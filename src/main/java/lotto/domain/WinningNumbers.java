package lotto.domain;

import static lotto.view.OutputView.printErrorMessage;

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
            printErrorMessage("[ERROR] 입력은 숫자만 가능합니다.");
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
            printErrorMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(String input) {
        int number = Integer.parseInt(input);
        if (winningNumbers().contains(number)) {
            printErrorMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
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
