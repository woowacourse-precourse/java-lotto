package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Constants.*;

public class InputView {
    public String inputMoney() {
        System.out.println(INPUT_MONEY);
        return readLine();
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
    }

    public void printRate(float earnedRate) {
        String rateNotice = String.format(EARNED_RATE, earnedRate);
        System.out.println(rateNotice);
    }
}
