package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Operation {
    static int buyAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    static List<Lotto> buyLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int buyAmount= buyAmount(purchaseAmount);
        for (int i = 0; i < buyAmount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    static List<Integer> generateNumbers() {
        List<Integer> result = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        result.sort(Comparator.naturalOrder());
        return result;
    }

    static int calculateEarning(Match match) {
        return match.match3 * 5000
                + match.match4 * 50000
                + match.match5 * 1500000
                + match.match5Bonus * 30000000
                + match.match6 * 2000000000;
    }

    static double calculateEarningRate(int purchaseAmount, int earning) {
        double earningRate = (double) earning / (double) purchaseAmount;
        earningRate = Math.round(earningRate * 1000) / 10.0;
        return earningRate;
    }

    static void playGame() {
        try {
            Print.getPurchaseAmount();
            int purchaseAmount = Input.getPurchaseAmount();
            List<Lotto> lottos = buyLotto(purchaseAmount);
            Print.userLottos(lottos, purchaseAmount);

            Print.getWinningNumbers();
            List<Integer> winning = Input.getWinningNumbers();
            Print.getBonusNumber();
            int bonus = Input.getBonusNumber(winning);

            Match match = new Match(lottos, winning, bonus);
            int earning = calculateEarning(match);
            double earningRate = calculateEarningRate(purchaseAmount, earning);
            Print.result(earningRate, match);
        } catch (IllegalArgumentException ignored) {
        }
    }
}
