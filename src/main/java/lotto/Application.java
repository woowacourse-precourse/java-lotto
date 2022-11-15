package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.LottoView;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        User user = new User();

        int number = lottoView.lottoPurchase();
        List<Lotto> list = user.randomLotto(number);

        lottoView.lottoPublish(list);

        System.out.println();

        String win = lottoView.winNum();
        Winning winning = new Winning();
        Lotto lotto = new Lotto(winning.winning(win));

        System.out.println();
        lottoView.bonusNum(lotto, user);

        winning.score(list, lotto.getNumbers(), user.getBonusNum());

        List<Integer> score = winning.score();

        double rate = winning.rate(score, number * 1000);

        System.out.println();

        lottoView.winView(winning, rate);
    }
}
