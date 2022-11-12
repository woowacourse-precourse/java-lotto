package lotto.Util;

import static lotto.Constant.ResultMessage.HIT_BONUS_NUMBER;
import static lotto.Constant.ResultMessage.LOTTO_NUM;
import static lotto.Constant.ResultMessage.PROFIT;
import static lotto.Constant.ResultMessage.RESULT_RANK;
import static lotto.Constant.ResultMessage.RESULT_START;

import java.text.DecimalFormat;

import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.Rank;



public class Printer {
    public static void printWinnings(List<Rank> ranks) {
        System.out.println(RESULT_START);

        for (Rank rank : Rank.getNoDefault()) {
            System.out.printf(RESULT_RANK,
                    rank.getHitCount(), printIfBonusHit(rank),
                    printFormatingMoney(rank.getPrizeMoney()),
                    Collections.frequency(ranks, rank)
            );
        }
    }

    public static String printIfBonusHit(Rank rank) {
        if (rank.getBonusHit()) {
            return HIT_BONUS_NUMBER;
        }

        return " ";
    }

    public static String printFormatingMoney(int money) {
        DecimalFormat moneyFormatter = new DecimalFormat("###,###");
        String formattedMoney = moneyFormatter.format(money);

        return formattedMoney;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_NUM, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printProfits(double profit) {
        System.out.printf(PROFIT, profit);
    }
}
