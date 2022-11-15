package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int userMoney = InputConsole.buyLotto();
            LottoGame lottoGame = new LottoGame(userMoney);

            List<Lotto> lotto = lottoGame.payForLotto(userMoney);

            List<Integer> winningNumber = InputConsole.inputNumber();

            int bonusNumber = InputConsole.inputBonusNumber();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
