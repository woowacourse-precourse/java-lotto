package lotto;

import lotto.model.Judgment;
import lotto.model.RankCounter;
import lotto.model.User;
import lotto.model.WinningNumbers;
import lotto.views.Input;
import lotto.views.Print;

import java.util.List;

public class LottoHandler {
    private final User user;
    private final WinningNumbers winningNumbers;
    private final Judgment judgment;

    public LottoHandler() throws IllegalArgumentException {
        this.user = new User();
        this.winningNumbers = new WinningNumbers();
        this.judgment = new Judgment(user, winningNumbers);
    }

    public void sellLotto() throws IllegalArgumentException {
        Print.printInsertMoney();
        long money = Input.readLong();

        user.payMoney(money);
        user.buyLotto();

        Print.printLottoList(user.getUserLottos());
    }

    public void pickWinningNumber() throws IllegalArgumentException {
        Print.printWinningNumber();
        List<Integer> newWinningNumbers = Input.readListInteger(",");
        winningNumbers.newWinningNumbers(newWinningNumbers);
    }

    public void pickBonusNumber() throws IllegalArgumentException {
        Print.printBonusNumber();
        int newBonusNumber = Input.readInteger();
        winningNumbers.newBonusNumber(newBonusNumber);
    }

    public void calculateResult() throws IllegalArgumentException {
        RankCounter rankCounter = judgment.calculateRank();
        Print.printRankCounter(rankCounter);

        double yield = judgment.calculateYield();
        Print.printYield(yield);
    }
}
