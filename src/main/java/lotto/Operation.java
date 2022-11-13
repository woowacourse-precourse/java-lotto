package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Operation {
    static int buyAmount(int purchaseAmount){
        return purchaseAmount / 1000;
    }

    static List<Lotto> buyLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyAmount(purchaseAmount); i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int random = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    static int calculateEarning(Match match) {
        int earning = 0;
        earning += match.match3 * 5000;
        earning += match.match4 * 50000;
        earning += match.match5 * 1500000;
        earning += match.match5Bonus * 30000000;
        earning += match.match6 * 2000000000;
        return earning;
    }

    static double calculateEarningRate(int purchaseAmount, int earning){
        double earningRate = (double) earning/ (double) purchaseAmount;
        earningRate= Math.round(earningRate * 1000) / 10.0;
        return earningRate;
    }


}
