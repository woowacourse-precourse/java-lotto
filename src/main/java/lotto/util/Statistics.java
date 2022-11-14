package lotto.util;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.enums.IntEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.enums.IntEnum.*;

public class Statistics {
    private final List<Integer> reward = List.of(5000, 50000, 1500000, 2000000000, 30000000);
    private final List<Integer> rank = new ArrayList<>(Collections.nCopies(BONUS_SIZE.getValue(), 0));

    public void compareNumber(List<Lotto> randomLottos, WinLotto winLotto) {
        List<Integer> winNumbers = winLotto.getWinNumbers().stream().limit(LOTTO_SIZE.getValue()).collect(Collectors.toList());
        int bonus = winLotto.getWinNumbers().get(LOTTO_SIZE.getValue());
        for (Lotto tmpLotto : randomLottos) {
            List<Integer> tmpNumber = tmpLotto.getNumbers();
            int countMatch = countCalculate(winNumbers, tmpNumber);
            if (countMatch == 5) checkHasBonus(bonus, countMatch, tmpNumber);
            if (countMatch != 5) rank.set(countMatch, rank.get(countMatch) + 1);
        }
    }

    private int countCalculate(List<Integer> winNumbers, List<Integer> tmpNumber) {
        int countMatch = 0;
        for (int winNumber : winNumbers) {
            if (tmpNumber.contains(winNumber)) countMatch++;
        }
        return countMatch;
    }

    private void checkHasBonus(int bonus, int count, List<Integer> tmpNumber) {
        if (tmpNumber.contains(bonus)) {
            rank.set(BONUS_SIZE.getValue(), rank.get(BONUS_SIZE.getValue()) + 1);
        }
        if (!tmpNumber.contains(bonus)) {
            rank.set(count, rank.get(count) + 1);
        }
    }

    public List<Integer> getRank() {
        return rank.stream().skip(3).collect(Collectors.toList());
    }

    public BigDecimal calculateProfitRate(Buyer buyer) {
        int profit = 0;
        List<Integer> cutRank = rank.stream().skip(3).collect(Collectors.toList());
        for (int index = 0; index < reward.size(); index++) {
            profit += cutRank.get(index) * reward.get(index);
        }
        return new BigDecimal(Math.round((profit / (double) buyer.getBuyPrice() * 100))).setScale(1, RoundingMode.HALF_EVEN);
    }

}
