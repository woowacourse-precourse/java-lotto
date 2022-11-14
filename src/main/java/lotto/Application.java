package lotto;

import lotto.controller.Controller;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.view.View;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View();
        Map<Rank, Integer> winningStat;
        double earningRate;

        try {
            List<Lotto> lottoPayed = controller.buyLotto();
            view.printLottoPayed(lottoPayed);

            controller.setWinningNums();

            winningStat = controller.getWinningStat(lottoPayed);
            earningRate = controller.getEarningRate(winningStat);

            view.printWinningStats(winningStat);
            view.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}
