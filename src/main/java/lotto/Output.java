package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Output {
    public static String budget;
    public static List<Lotto> lottos;
    private static TreeMap<Prize, Integer> stats;
    public static void askBuy() {
        System.out.println(Print.ASK_BUY);
        budget = Input.inputBudget();
    }

    public static void answerBuy() {
        lottos = Lotto.getLotto(budget);
        System.out.println(lottos.size() + Print.ANSWER_BUY);
    }

    public static void printLotto() {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void askPrizeNum() {
        System.out.println(Print.ASK_PRIZE);
        PrizeNum.setPrizeNum();
    }

    public static void askBonusNum() {
        System.out.println(Print.ASK_BONUS);
        PrizeNum.setBonusNum();
    }

    public static void printLottoStat() {
        System.out.println(Print.ANALYSE_PRIZE);
        Analyse.analyseLotto(lottos, PrizeNum.getPrize());

        stats = Analyse.getStats();

        for(Prize p : stats.descendingKeySet()) {
            System.out.println(p.getPrizePrint() + " - " + stats.get(p) + "개");
        }
    }
}
