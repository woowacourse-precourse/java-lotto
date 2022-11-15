package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbersGenerateView {
    public void requestWinningNumbers() {
        System.out.println(GuideMessage.WINNING_NUMBERS_REQUEST);
    }

    public void requestBonusNumber() {
        System.out.println(GuideMessage.BONUS_NUMBER_REQUEST);
    }

    public String getInput() {
        return Console.readLine();
    }
}
