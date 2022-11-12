package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String COMMA = ",";
    private static final String ERROR_NUMBER_ONLY = "[ERROR] 투입금액은 숫자만 입력가능합니다.";
    private static final String ERROR_WINNING_NUMBER_INPUT = "[ERROR] 당첨번호가 숫자가 아닙니다.";
    private static final String MESSAGE_MONEY_INPUT = "구입금액을 입력해주세요.";
    private static final String MESSAGE_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    public static int getMoneyInput() {
        OutputView.printString(MESSAGE_MONEY_INPUT);
        String moneyInput = Console.readLine();
        if (!moneyInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
        return Integer.parseInt(moneyInput);
    }

    public static List<Integer> getWinningInput() {
        OutputView.printString(MESSAGE_WINNING_INPUT);
        String winningInput = Console.readLine();
        List<String> tempLotto = Arrays.asList(winningInput.split(COMMA));
        List<Integer> lotto = new ArrayList<>();
        for (String tempNumber : tempLotto) {
            if (!tempNumber.matches(NUMBER_REGEX)){
                throw new IllegalArgumentException(ERROR_WINNING_NUMBER_INPUT);
            }
            lotto.add(Integer.parseInt(tempNumber));
        }
        return lotto;
    }

    public static int getBonusInput() {
        OutputView.printString(MESSAGE_BONUS_INPUT);
        String bonusInput = Console.readLine();
        if (!bonusInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
        return Integer.parseInt(bonusInput);
    }
}
