package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class LottoService {
    public static LinkedHashMap<Prize, Integer> lottoNumberComparison(List<Lotto> lotteryNumbers, LuckyNumber luckyNumber) {
        LinkedHashMap<Prize, Integer> history = historyInit();

        for (Lotto userNumber : lotteryNumbers) {
            List<Integer> userNum = userNumber.getNumbers();
            List<Integer> luckyNum = luckyNumber.getLuckyNumber().getNumbers();

            int matchN = matchN(userNum, luckyNum);
            int matchBonusN = matchBonusN(userNum, luckyNumber.getBonusNumber());

            Prize prize = Prize.winLotto(matchN, matchBonusN);
            history.replace(prize, history.get(prize) + 1);
        }

        return history;
    }

    static int matchN(List<Integer> userNumber, List<Integer> luckyNumber) {
        int count = 0;
        for (Integer number : userNumber) {
            if (luckyNumber.contains(number)) count++;
        }
        return count;
    }

    static int matchBonusN(List<Integer> userNumber, int bonusNumber) {
        if (userNumber.contains(bonusNumber)) return 1;
        return 0;
    }

    public static String calculateYield(HashMap<Prize, Integer> history, int purchaseAmount) {
        float total = calculateTotal(history);

        return String.format("%.1f", (total / purchaseAmount) * 100);
    }

    static float calculateTotal(HashMap<Prize, Integer> history) {
        float total = 0.0F;

        if (history.containsKey(Prize.FIFTH_PLACE))
            total += Prize.FIFTH_PLACE.getAmount() * history.get(Prize.FIFTH_PLACE);
        if (history.containsKey(Prize.FOURTH_PLACE))
            total += Prize.FOURTH_PLACE.getAmount() * history.get(Prize.FOURTH_PLACE);
        if (history.containsKey(Prize.THIRD_PLACE))
            total += Prize.THIRD_PLACE.getAmount() * history.get(Prize.THIRD_PLACE);
        if (history.containsKey(Prize.SECOND_PLACE))
            total += Prize.SECOND_PLACE.getAmount() * history.get(Prize.SECOND_PLACE);
        if (history.containsKey(Prize.FIRST_PLACE))
            total += Prize.FIRST_PLACE.getAmount() * history.get(Prize.FIRST_PLACE);

        return total;
    }

    private static LinkedHashMap<Prize, Integer> historyInit() {
        LinkedHashMap<Prize, Integer> history = new LinkedHashMap<>();
        history.put(Prize.FIFTH_PLACE, 0);
        history.put(Prize.FOURTH_PLACE, 0);
        history.put(Prize.THIRD_PLACE, 0);
        history.put(Prize.SECOND_PLACE, 0);
        history.put(Prize.FIRST_PLACE, 0);
        history.put(Prize.LOSING_TICKET, 0);
        return history;
    }

}
