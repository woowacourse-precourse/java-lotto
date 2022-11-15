package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoConfig;
import lotto.domain.user.User;
import lotto.view.Message;
import lotto.view.RankingView;
import lotto.view.Store;

public class Dispatch {
    private final LottoConfig lottoConfig;
    private User user;

    public Dispatch(LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public void buyLotto(){
        System.out.println(Message.SELLING_MSG);
        this.user = new User(Console.readLine());

        Store store  = lottoConfig.userController().buyLotto(user);
        store.show();
    }

    public void drawLotto(){
        System.out.println(Message.CHOOSE_WINNING_NUMBERS);
        String winningNumber = Console.readLine();

        System.out.println(Message.CHOOSE_BONUS_NUMBER);
        String bonus = Console.readLine();

        RankingView rankingView = lottoConfig.rankController()
                .statistics(this.user, winningNumber, bonus);
        rankingView.show();
    }
}
