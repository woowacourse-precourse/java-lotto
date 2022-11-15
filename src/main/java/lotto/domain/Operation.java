package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.instance.Setting.*;

public class Operation {

    public static int buyAmount(int purchaseAmount) {
        return purchaseAmount / BASIC_AMOUNT;
    }

    public static List<Lotto> buyLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int buyAmount = buyAmount(purchaseAmount);
        for (int i = 0; i < buyAmount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    public static List<Integer> generateNumbers() {
        List<Integer> result = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUMBER_OF_NUMBERS));
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public static int calculateEarning(Match match) {
        int result = match.MATCH_THREE * AMOUNT_THREE;
        result += match.MATCH_FOUR * AMOUNT_FOUR;
        result += match.MATCH_FIVE * AMOUNT_FIVE;
        result += match.MATCH_FIVE_BONUS * AMOUNT_FIVE_BONUS;
        result += match.MATCH_SIX * AMOUNT_SIX;
        return result;
    }

    public static double calculateEarningRate(int purchaseAmount, int earning) {
        double earningRate = (double) earning / (double) purchaseAmount;
        earningRate = Math.round(earningRate * 1000) / 10.0;
        return earningRate;
    }

}

