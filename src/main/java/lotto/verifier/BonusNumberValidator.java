package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class BonusNumberValidator {

    public int askBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        validateInput(input, winningNumbers);

        return Integer.parseInt(input);
    }

    private void validateInput(String input, List<Integer> winningNumbers) {
        if (!isFrom1To45(input)) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        if (isDuplicatedWithWinningNumber(input, winningNumbers)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복되면 안됩니다.");
        }
    }

    private boolean isFrom1To45(String input) {
        String pattern = "[1-9]|[1-4][0-9]";
        return Pattern.matches(pattern, input);
    }

    private boolean isDuplicatedWithWinningNumber(String input, List<Integer> winningNumbers) {
        int parseInt = Integer.parseInt(input);
        return winningNumbers.contains(parseInt);
    }
}
