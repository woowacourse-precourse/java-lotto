package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoCalculate.LottoPrizeMoneyMatchCount;

public class OutputView {
    final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    final String PRIZE_MESSAGE1_HEAD = "\n당첨 통계\n---";
    final String PRIZE_MESSAGE2_MATCH_COUNT = "%d개 일치";
    final String PRIZE_MESSAGE3_BONUS_EQUAL = ", 보너스 볼 일치";
    final String PRIZE_MESSAGE4_PRIZE_MONEY_AND_COUNT = " (%s원) - %d개\n";
    final String PERCENTAGE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseAmount(int lottoAmount) {
        System.out.println("\n" + lottoAmount + PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printPrize(Map<Integer, Integer> prize) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(PRIZE_MESSAGE1_HEAD);
        for (int key = 5; key > 0; key--) {
            LottoPrizeMoneyMatchCount lottoPrizeMoneyMatchCount = getLottoPrizeMoney(key);
            System.out.printf(PRIZE_MESSAGE2_MATCH_COUNT, lottoPrizeMoneyMatchCount.matchCount);
            if (lottoPrizeMoneyMatchCount.prize == 2) {
                System.out.print(PRIZE_MESSAGE3_BONUS_EQUAL);
            }
            System.out.printf(PRIZE_MESSAGE4_PRIZE_MONEY_AND_COUNT,
                    decFormat.format(lottoPrizeMoneyMatchCount.prizeMoney),
                    prize.get(lottoPrizeMoneyMatchCount.prize));
        }
    }

    private LottoPrizeMoneyMatchCount getLottoPrizeMoney(int key) {
        if (key == 1) {
            return LottoPrizeMoneyMatchCount.FIRST;
        } else if (key == 2) {
            return LottoPrizeMoneyMatchCount.SECOND;
        } else if (key == 3) {
            return LottoPrizeMoneyMatchCount.THIRD;
        } else if (key == 4) {
            return LottoPrizeMoneyMatchCount.FOURTH;
        }
        return LottoPrizeMoneyMatchCount.FIFTH;
    }

    public void printPercentageOfReturn(float percentageOfReturn) {
        System.out.printf(PERCENTAGE_OF_RETURN_MESSAGE, percentageOfReturn);
    }
}