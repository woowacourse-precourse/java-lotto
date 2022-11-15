package lotto.start;
import lotto.game.*;
import lotto.view.*;
import java.util.List;
import java.util.ArrayList;
public class gameStart {
    public void run() {
        long inputMoney = inputView.getUserMoney();
        user user = new user(inputMoney, buyLotto(inputMoney));
        outputView.showPurchasedLotto(user);

        winningNumber winnerNumber = getWinningNumber();
        List<rank> ranks = getRanks(user, winnerNumber);

        outputView.showGameResult(user, ranks);
    }

    public List<Lotto> buyLotto(long money) {
        return lottoMachine.order(money);
    }

    public winningNumber getWinningNumber() {
        Lotto lotto = new Lotto(inputView.getWinningNumber());
        int bonusNumber = inputView.getBonusNumber();

        return new winningNumber(lotto, bonusNumber);
    }

    public List<rank> getRanks(user user, winningNumber winningNumber) {
        List<rank> ranks = new ArrayList<>();

        for (Lotto lotto : user.getLottos()) {
            rank Rank = rank.calculate(lotto, winningNumber);
            ranks.add(Rank);
        }
        return ranks;
    }
}
