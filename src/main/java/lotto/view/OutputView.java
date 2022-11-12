package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoCalculate.LottoPrizeMoneyMatchCount;

public class OutputView {
    final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    final String PRIZE_MESSAGE1 = "\n당첨 통계\n---";
    final String PRIZE_MESSAGE2 = "개 일치";
    final String PRIZE_MESSAGE3 = ", 보너스 볼 일치";
    final String PRIZE_MESSAGE4 = " (";
    final String PRIZE_MESSAGE5 = "원) - ";
    final String PRIZE_MESSAGE6 = "개";
    final String PERCENTAGE_OF_RETURN_MESSAGE1 = "총 수익률은 ";
    final String PERCENTAGE_OF_RETURN_MESSAGE2 = "%입니다.";
    DecimalFormat decFormat = new DecimalFormat("###,###");

    public void printPurchaseAmount(int lottoAmount) {
        System.out.println("\n" + lottoAmount + PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printPrize(Map<Integer, Integer> prize) {
        System.out.println(PRIZE_MESSAGE1);
        for (int key = 5; key > 0; key--) {
            LottoPrizeMoneyMatchCount lottoPrizeMoneyMatchCount = getLottoPrizeMoney(key);
            System.out.print(lottoPrizeMoneyMatchCount.matchCount + PRIZE_MESSAGE2);
            if (lottoPrizeMoneyMatchCount.prize == 2) {
                System.out.print(PRIZE_MESSAGE3);
            }
            System.out.print(PRIZE_MESSAGE4 + decFormat.format(lottoPrizeMoneyMatchCount.prizeMoney) + PRIZE_MESSAGE5);
            System.out.println(prize.get(lottoPrizeMoneyMatchCount.prize) + PRIZE_MESSAGE6);
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

    public void printPercentageOfReturn(double percentageOfReturn) {
        System.out.print(PERCENTAGE_OF_RETURN_MESSAGE1 + percentageOfReturn + PERCENTAGE_OF_RETURN_MESSAGE2);
    }
}