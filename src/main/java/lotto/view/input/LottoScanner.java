package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoScanner {

    private static final String NOT_ONLY_NUMBER = "숫자만 입력해 주세요";
    private static final String INVALID_FORMAT_OF_WINNING_NUMBER = "올바른 당첨 번호 포맷이 아닙니다.";

    // 로또 구입 금액을 입력 받는 로직
    public String money() {
        String money = Console.readLine();
        validateItContainsOnlyNumber(money);

        return money;
    }

    // 당첨 번호를 입력받는 로직
    public String winningNumber() {
        String winningNumber = Console.readLine();
        validateWinningNumberFormat(winningNumber);

        return winningNumber;
    }

    // 보너스 번호를 입력받는 로직
    public String bonusNumber() {
        String bonusNumber = Console.readLine();
        validateItContainsOnlyNumber(bonusNumber);

        return bonusNumber;
    }

    void validateItContainsOnlyNumber(String money) {
        final String REGEX = "\\d+";
        if (!money.matches(REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER);
        }
    }

    // 이건 여기에 있는게 맞을까..?
    void validateWinningNumberFormat(String winningNumber) {
        final String REGEX = "(\\d+,){5}\\d+";
        if (!winningNumber.matches(REGEX)) {
            throw new IllegalArgumentException(INVALID_FORMAT_OF_WINNING_NUMBER);
        }
    }
}
