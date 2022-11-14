package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Controller {
    private static final String NUMERIC_STRING_ERROR_MESSAGE = "숫자 형식으로 입력해 주세요.";
    private static final String DIVISIBLE_THOUSAND_ERROR_MESSAGE = "구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void run() {
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String numericString = Console.readLine();
        return formatStringToNumber(numericString);
    }

    private int formatStringToNumber(String numericString) {
        checkNumericString(numericString);
        int number = Integer.parseInt(numericString);
        checkDivisibleThousand(number);

        return number;
    }

    private void checkNumericString(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            Logger.log(NUMERIC_STRING_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkDivisibleThousand(int number) {
        if (number % 1000 != 0) {
            Logger.log(DIVISIBLE_THOUSAND_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void printPublishedLotto(List<Lotto> lottos) {

    }

    private List<Integer> calculateWonLotto(List<Lotto> lottos) {
        return null;
    }

    private void printWonLotto(List<Integer> rankCounts) {
    }

    private void printYield(int loss, int profit) {
    }
}
