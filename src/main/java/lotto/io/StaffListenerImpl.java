package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class StaffListenerImpl implements StaffListener {
    private static final String receiveMoneyMessage = "구입금액을 입력해 주세요.";
    private static final String listenMainWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String listenBonusWinningNumbersMessage = "보너스 번호를 입력해 주세요.";
    @Override
    public String receiveMoney() {
        System.out.println(receiveMoneyMessage);
        String money = Console.readLine();
        return money;
    }

    @Override
    public String listenMainWinningNumbers() {
        System.out.println(listenMainWinningNumbersMessage);
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    @Override
    public String listenBonusWinningNumber() {
        System.out.println(listenBonusWinningNumbersMessage);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
