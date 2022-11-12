package lotto.domain;

import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumber {
    private Set<Integer> winningNumber;

    public void inputWinningNumber(String input) {
        if (!isSixStrings(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_SIX_TOKEN.getMessage());
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
        if (!isRangeNumber()) {
            throw new IllegalArgumentException(Error.IS_NOT_RANGE.getMessage());
        }
        if (!isSixNumber()) {
            throw new IllegalArgumentException(Error.IS_NOT_UNIQUE.getMessage());
        }

    }

    private boolean isSixNumber() {
        return winningNumber.size() == 6;
    }

    private boolean isRangeNumber() {
        return winningNumber.stream().allMatch(a -> a >= 1 && a <= 45);
    }

    private boolean isSixStrings(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        return st.countTokens() == 6;
    }

    private boolean isNumber(String input) { //인덴트 초과
        String[] numbers = input.split(",");
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) < '0' && number.charAt(i) > '9') {
                    return false;
                }
            }
            winningNumber.add(Integer.parseInt(number)); //메소드 두개인데
        }
        return true;
    }
}
