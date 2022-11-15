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

        printWinRecords(winRecords);

        float profit = computeProfit(money.getMoney(), winRecords);
        printProfit(profit);
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

    private void printWinRecords(HashMap<String, Integer> winRecords) {
        final String TITLE = "당첨 통계";
        final String DIVISION_LINE = "---";

        System.out.println(TITLE);
        System.out.println(DIVISION_LINE);

        for (LottoWinType winType : LottoWinType.values()) {
            String winMessage = winType.getEventMessage();
            int winNumber = winRecords.get(winType.getKey());
            String replaceFrom = "$";
            replaceFrom = replaceFrom.concat(winType.getKey());
            winMessage = winMessage.replace(replaceFrom, Integer.toString(winNumber));

            System.out.println(winMessage);
        }
    }

    private float computeProfit(int money, HashMap<String, Integer> winRecords) {
        float profit = 0;

        for (LottoWinType winType : LottoWinType.values()) {
            profit += winRecords.get(winType.getKey()) * winType.getPrizeMoney();
        }

        profit = profit / (float) money * 100;

        return profit;
    }

    private void printProfit(float profit) {
        String text = "총 수익률은 $profit%입니다.";
        String replaceFrom = "$profit";
        String rateOfProfit = String.format("%.1f", profit);
        text = text.replace(replaceFrom, rateOfProfit);

        System.out.println(text);
    }
}

