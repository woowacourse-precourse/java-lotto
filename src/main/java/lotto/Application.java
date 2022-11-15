package lotto;

import static lotto.util.NumberParser.stringArrayToIntegerList;
import static lotto.util.NumberParser.stringToInteger;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.View;

public class Application {

    public static void main(String[] args) {
        try {
            View view = new View();
            view.printInputMoneyMenu();
            LottoMachine lottoMachine = new LottoMachine(stringToInteger(view.readLine()));
            view.printLottoCount(lottoMachine.getPurchasedLottoCount());
            view.print(lottoMachine.lottosToString());
            view.printInputWinningNumbersMenu();
            Lotto winningLotto = new Lotto(stringArrayToIntegerList(view.readLine().split(",")));
            view.printInputBonusNumberMenu();
            int bonusNumber = stringToInteger(view.readLine());
            winningLotto.validateBonusNumber(bonusNumber);
            lottoMachine.checkLottosRank(winningLotto, bonusNumber);
            view.printRankStatistic(lottoMachine.rankStatisticsToString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
