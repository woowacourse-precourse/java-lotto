package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String COMMA = ",";
    private static final int LOTTO_RANGE_MAX = 45;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final String ERROR_NUMBER_ONLY = "[ERROR] 투입금액은 숫자만 입력가능합니다.";
    private static final String ERROR_NUMBER_RANGE = "[ERROR] 1부터 45 사이의 숫자만 입력가능합니다.";
    private static final String ERROR_WINNING_NUMBER_INPUT = "[ERROR] 당첨번호가 숫자가 아닙니다.";
    private static final String MESSAGE_MONEY_INPUT = "구입금액을 입력해주세요.";
    private static final String MESSAGE_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    public static int getMoneyInput() {
        OutputView.printString(MESSAGE_MONEY_INPUT);
        String moneyInput = Console.readLine();
        OutputView.enterLine();
        if (!moneyInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
        return Integer.parseInt(moneyInput);
    }

    public static Lotto getWinningInput() {
        OutputView.printString(MESSAGE_WINNING_INPUT);
        String winningInput = Console.readLine();
        OutputView.enterLine();
        List<String> tempLotto = Arrays.asList(winningInput.split(COMMA));
        List<Integer> numbers = new ArrayList<>();
        for (String tempNumber : tempLotto) {
            if (!tempNumber.matches(NUMBER_REGEX)) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBER_INPUT);
            }
            numbers.add(Integer.parseInt(tempNumber));
        }
        return new Lotto(numbers);
    }

    public static int getBonusInput() {
        OutputView.printString(MESSAGE_BONUS_INPUT);
        String bonusInput = Console.readLine();
        OutputView.enterLine();
        if (!bonusInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
        int number = Integer.parseInt(bonusInput);
        if (number > LOTTO_RANGE_MAX || number < LOTTO_RANGE_MIN) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
        return number;
    }
}
