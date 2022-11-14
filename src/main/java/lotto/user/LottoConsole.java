package lotto.user;

import lotto.enumeration.ConsoleAlert;
import lotto.store.LottoDraw;

public class LottoConsole {
    private final LottoDraw lottoDraw = LottoDraw.getInstance();

    public void doLotto() {
        System.out.println(ConsoleAlert.START_ALERT.toAlertString());
        Customer customer = new Customer(camp.nextstep.edu.missionutils.Console.readLine());
        System.out.println(customer.toLottoString());
        System.out.println(ConsoleAlert.INPUT_WIN_NUMBERS_ALERT.toAlertString());
        String winNumbers = drawWinNumbers(camp.nextstep.edu.missionutils.Console.readLine());
        System.out.println(ConsoleAlert.INPUT_BONUS_NUMBER_ALERT.toAlertString());
        String bonusNumber = drawBonusNumber(camp.nextstep.edu.missionutils.Console.readLine());
        customer.createWinnings(winNumbers, bonusNumber);
        System.out.println(customer.toResultString());
    }

    private String drawWinNumbers(String readLine) {
        lottoDraw.pickWinNumbers(readLine);
        return readLine;
    }

    private String drawBonusNumber(String readLine) {
        lottoDraw.pickBonusNumber(readLine);
        return readLine;
    }

}
