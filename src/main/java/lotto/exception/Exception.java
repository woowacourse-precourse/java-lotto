package lotto.exception;

import lotto.domain.Lotto;

import java.util.List;

public class Exception {
    private static final char INPUT_START = '0';
    private static final char INPUT_END = '9';
    public static final String ERROR = "[ERROR]";

    public static void validateIsNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            checkInterval(input.charAt(i), INPUT_START, INPUT_END);
        }
    }

    private static void checkInterval(char input, char startNumber, char endNumber) {
        if (input < startNumber || input > endNumber) {
            throw new IllegalArgumentException(ERROR + "숫자만 입력해주세요.");
        }
    }

    public static void validateIsThousandUnit(String input){
        if (Integer.parseInt(input)%1000 != 0) {
            throw new IllegalArgumentException(ERROR + "천 단위로 입력해주세요.");
        }
    }

    public static void validateIsLessThanThousand(String input) {
        if (Integer.parseInt(input)<1000) {
            throw new IllegalArgumentException(ERROR + "구매금액은 1000 이상이어야 합니다.");
        }
    }

    public static void validateIsDuplicatedWithWinningLotto(Lotto winningLotto, int bonusNumber) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (Integer number: numbers) {
            checkIsMatched(number, bonusNumber);
        }
    }

    private static void checkIsMatched(Integer number, int bonusNumber){
        if (number == bonusNumber) {
            throw new IllegalArgumentException(ERROR + "보너스번호가 우승 번호와 중복됩니다.");
        }
    }
}
