package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningPrize;
import lotto.domain.WinningRate;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputConsole inputConsole = new InputConsole();


        try {
            int userMoney = inputConsole.buyLotto();
            LottoGame lottoGame = new LottoGame(userMoney);
            List<Lotto> lotto = lottoGame.payForLotto(userMoney);
            lottoGame.printLotto(lotto);

            List<Integer> winningNumber = InputConsole.inputNumber();
            int bonusNumber = InputConsole.inputBonusNumber();

            WinningPrize checkPrize = new WinningPrize(lotto, (Lotto) winningNumber, bonusNumber);

            Map<String, Integer> totalPrize = checkPrize.getTotalPrize();
            WinningRate winningRate = new WinningRate(userMoney, totalPrize);
            winningRate.printTotalPrize(totalPrize);

            double profitRate = winningRate.getProfitRate();
            winningRate.printProfitRate(profitRate);


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }






    }
}
