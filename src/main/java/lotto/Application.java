package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        Print.printInsertMoney();
        int money = Input.readInteger();

        user.payMoney(money);
        user.buyLotto();

        Print.printLotto(user.getUserLottos());

        WinningNumbers winningNumbers = new WinningNumbers();

        Print.printWinningNumber();
        List<Integer> newWinningNumbers = Input.readListInteger(",");
        winningNumbers.newWinningNumbers(newWinningNumbers);

        Print.printBonusNumber();
        int newBonusNumber = Input.readInteger();
        winningNumbers.newBonusNumber(newBonusNumber);

        Judgment judgment = new Judgment(user, winningNumbers);
        RankCounter rankCounter = judgment.calculateRank();
        Print.printRankCounter(rankCounter);
    }
}
