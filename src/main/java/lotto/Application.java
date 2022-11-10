package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message.NormalMessage;

public class Application {
    public static void main(String[] args) {

        // 구입금액 입력 메시지 출력
        NormalMessage.printMoneyInputMessage();
        User user= new User(Console.readLine().trim());

        // 구매 후 메시지 출력
        user.buyLotto();
        NormalMessage.printBuyMessage(user);

        // 당첨번호 입력 메시지 출력
        NormalMessage.printWinningNumberInputMessage();
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.readWinningNumbers();

        // 보너스번호 입력 메시지 출력
        NormalMessage.printBonusNumberInputMessage();
        winningNumber.readBonusNumber();

        // 당첨 결과 출력
        WinningResult winningResult = new WinningResult(user, winningNumber);
        winningResult.makeWinningResult();
        NormalMessage.printResultMessage(winningResult);
    }
}