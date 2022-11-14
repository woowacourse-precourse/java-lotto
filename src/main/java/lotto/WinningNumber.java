package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final static String SEPARATOR = ",";
    private final static int REPEAT_DEFAULT = 0;

    private final Lotto lotto;

    public WinningNumber(String winningNumber) {
        this.lotto = new Lotto(validate(winningNumber));
    }

    private List<Integer> validate(String winningNumber) {
        List<String> winningNumbers = validateSplitWinningNumbers(winningNumber);
        return validateWinningNumberTypeCheck(winningNumbers);
    }

    private List<String> validateSplitWinningNumbers(String winningNumber) {
        return List.of(winningNumber.split(SEPARATOR));
    }

    private List<Integer> validateWinningNumberTypeCheck(List<String> tempWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = REPEAT_DEFAULT; i < tempWinningNumber.size(); i++) {
            validateWinningNumberType(i, winningNumbers, tempWinningNumber);
        }
        return winningNumbers;
    }

    private void validateWinningNumberType(int repeatCount, List<Integer> winningNumbers, List<String> tempWinningNumber) {
        try {
            winningNumbers.add(Integer.parseInt(tempWinningNumber.get(repeatCount)));
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호가 숫자가 아닙니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

}
