package lotto.user;

import lotto.store.LottoDraw;

public class LottoConsole {
    private static final String START_ALERT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_ALERT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_ALERT = "보너스 번호를 입력해 주세요.";
    private final LottoDraw lottoDraw = LottoDraw.getInstance();

    public void doLotto() {
            System.out.println(START_ALERT);
            Customer customer = new Customer(camp.nextstep.edu.missionutils.Console.readLine());
            System.out.println(customer.toLottoString());
            System.out.println(INPUT_WIN_NUMBERS_ALERT);
            String winNumbers = drawWinNumbers(camp.nextstep.edu.missionutils.Console.readLine());
            System.out.println(INPUT_BONUS_NUMBER_ALERT);
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
