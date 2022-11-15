package lotto;

import lotto.controller.Result;
import lotto.controller.Generator;
import lotto.domain.Lotto;
import lotto.domain.Win;
import lotto.view.Input;
import lotto.view.Messages;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int Money = Input.askMoney();
        int lottoCount = Input.inputMoney(Money);

        System.out.println(Messages.PRINT_BUY_LOTTO(lottoCount));;

        List<Lotto> lottos = Generator.getLottos(lottoCount);

        System.out.println(Messages.PRINT_LOTTOS(lottos));

        Lotto winLotto = Input.askWinLotto();

        int bonusNum = Input.askBonusNum(winLotto);

        Map<Win, Integer> countWins = Result.countWins(winLotto,bonusNum,lottos);

        double winningsRate = Result.winningsRate(Money, countWins);
        System.out.println(Messages.PRINT_RESULT(countWins,winningsRate));
    }
}
