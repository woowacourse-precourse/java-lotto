package lotto.service;

import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.Message;

public class LottoService {
    private User user;
    private Winning winning;

    public LottoService() {
        user = new User();
        winning = new Winning();
    }

    public void buy() throws IllegalArgumentException {
        Message.printBuy();
        user.buy();
    }

    public void printLotto() {
        Message.printBuyResult(user);
    }

    public void createWinning() throws IllegalArgumentException {
        Message.printWinningNum();
        winning.pickNum();
        Message.printWinningBonus();
        winning.pickBonus();
        winning.compare(user);
    }

    public void printResult() {
        Message.printWinningResult(user);
    }
}
