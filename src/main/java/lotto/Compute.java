package lotto;

/*
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compute {
    private final HashMap<String, Integer> winRecords;
    private final float profit;

    public Compute(Lottos lottos, WinningNumbers winningNumbers, Money money) {
        HashMap<String, Integer> winRecords = initializeWinRecords();

        for (Lotto lotto : lottos.getLottos()) {
            winRecords = computeWinRecords(
                    winRecords,
                    lotto.getNumbers(),
                    winningNumbers.getWinningNumbers(),
                    winningNumbers.getBonusNumber()
            );
        }

        this.winRecords = winRecords;
        this.profit = computeProfit(money.getMoney(), winRecords);
    }
    private HashMap<String, Integer> initializeWinRecords() {
        HashMap<String, Integer> winRecords = new HashMap<>();

        for (LottoWinType winType : LottoWinType.values()) {
            winRecords.put(winType.getKey(), 0);
        }
        return winRecords;
    }

    private HashMap<String, Integer> computeWinRecords(
            HashMap<String, Integer> winRecords,
            List<Integer> lotto,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        boolean containsBonusNumber = lotto.contains(bonusNumber);

        List<Integer> matchingNumbers = new ArrayList<>(lotto);
        matchingNumbers.retainAll(winningNumbers);
        int count = matchingNumbers.size();

        for (LottoWinType winType : LottoWinType.values()) {
            if (containsBonusNumber == winType.getWinBonusNumber() && count == LottoWinType.FIVE_BONUS.getValue()) {
                String key = winType.getKey();
                winRecords.put(key, winRecords.get(key) + 1);
                break;
            }
            else if (count == winType.getValue()) {
                String key = winType.getKey();
                winRecords.put(key, winRecords.get(key) + 1);
            }
        }

        return winRecords;
    }

    public HashMap<String, Integer> getWinRecords() {
        return this.winRecords;
    }

    private float computeProfit(int money, HashMap<String, Integer> winRecords) {
        float profit = 0;

        for (LottoWinType winType : LottoWinType.values()) {
            profit += winRecords.get(winType.getKey()) * winType.getPrizeMoney();
        }

        profit = profit / (float) money * 100;

        return profit;
    }

    public float getProfit() {
        return this.profit;
    }
}

