package lotto;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import lotto.Constant.ResultMessage;



public class Printer {
    public static void printWinnings(List<Rank> ranks) {
        System.out.println(ResultMessage.RESULT_START);

        for (Rank rank : Rank.getNoDefault()) {
            System.out.printf(ResultMessage.RESULT_RANK,
                    rank.getHitCount(), printIfBonusHit(rank),
                    printFormatingMoney(rank.getPrizeMoney()),
                    Collections.frequency(ranks, rank)
            );
        }
    }

    public static String printIfBonusHit(Rank rank) {
        if (rank.getBonusHit()) {
            return ResultMessage.HIT_BONUS_NUMBER;
        }

        return " ";
    }

    public static String printFormatingMoney(int money) {
        DecimalFormat moneyFormatter = new DecimalFormat("###,###");
        String formattedMoney = moneyFormatter.format(money);

        return formattedMoney;
    }


    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(ResultMessage.LOTTO_NUM, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
