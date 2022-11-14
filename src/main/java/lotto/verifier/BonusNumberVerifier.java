package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumberVerifier {

    public int askBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        String input = Console.readLine();

        validateInput(input, winningNumbers);

        return Integer.parseInt(input);
    }

    private void validateInput(String input, List<Integer> winningNumbers) {

        if (input.length() != 1) {
            throw new IllegalArgumentException("한 글자여야 합니다.");
        }
        if (!isDigit(input)) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        if (isDuplicatedWithWinningNumber(input, winningNumbers)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복되면 안됩니다.");
        }
    }

    private boolean isDigit(String input) {
        return '0' <= input.charAt(0) && input.charAt(0) <= '9';
    }

    private boolean isDuplicatedWithWinningNumber(String input, List<Integer> winningNumbers) {
        return true;
    }
}
