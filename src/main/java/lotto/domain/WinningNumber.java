package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningNumber {
    private Lotto winningNumber;

    public void inputWinningNumber(String input) {
        isNumber(separateCommas(input));
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
        if (!isRangeNumber()) {
            throw new IllegalArgumentException(Error.IS_NOT_RANGE.getMessage());
        }
        if (!isSixNumber()) {

        }

    }

    private void isSixNumber() {
        if (winningNumber.size() == 6) {
            throw new IllegalArgumentException(Error.IS_NOT_UNIQUE.getMessage());
        }
    }

    private boolean isRangeNumber() {
        return winningNumber.stream().allMatch(a -> a >= 1 && a <= 45);
    }

    private String[] separateCommas(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException(Error.IS_NOT_SIX.getMessage());
        }
        return inputs;
    }

    private boolean isNumber(String[] inputs) { //인덴트 초과
        Set<Integer> numbers = new HashSet<>();
        for (String input : inputs) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                    return false;
                }
            }
            numbers.add(Integer.parseInt(input)); //메소드 두개인데
        }
        return true;
    }
}
