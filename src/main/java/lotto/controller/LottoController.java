package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private User user = new User();
    private List<Lotto> userLotto = new ArrayList<>();
    private int money = 0;
    private Winning winning = new Winning();
    private Lotto lotto;

    public void run() {
        lottoBuy();
        winningNumber();
        printScore();
    }

    public void lottoBuy() {
        money = lottoView.lottoPurchase();
        userLotto = user.randomLotto(money);
        lottoView.lottoPublish(userLotto);
        System.out.println();
    }

    public void winningNumber() {
        String win = lottoView.winNum();
        lotto = new Lotto(winning.winning(win));
        System.out.println();
        lottoView.bonusNum(lotto, user);
    }

    public void printScore() {
        winning.score(userLotto, lotto, user.getBonusNum());
        double rate = winning.rate(money * 1000);
        System.out.println();
        lottoView.winView(winning, rate);
    }
}
