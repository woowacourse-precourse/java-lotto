package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.Instance.*;

public class Operation {

    static int buyAmount(int purchaseAmount) {
        return purchaseAmount / BASIC_AMOUNT;
    }

    static List<Lotto> buyLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int buyAmount = buyAmount(purchaseAmount);
        for (int i = 0; i < buyAmount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    static List<Integer> generateNumbers() {
        List<Integer> result = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUMBER_OF_NUMBERS));
        result.sort(Comparator.naturalOrder());
        return result;
    }

    static int calculateEarning(Match match) {
        return match.MATCH_THREE * AMOUNT_THREE
                + match.MATCH_FOUR * AMOUNT_FOUR
                + match.MATCH_FIVE * AMOUNT_FIVE
                + match.MATCH_FIVE_BONUS * AMOUNT_FIVE_BONUS
                + match.MATCH_SIX * AMOUNT_SIX;
    }

    static double calculateEarningRate(int purchaseAmount, int earning) {
        double earningRate = (double) earning / (double) purchaseAmount;
        earningRate = Math.round(earningRate * 1000) / 10.0;
        return earningRate;
    }

}

