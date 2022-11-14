package lotto;

import java.math.BigDecimal;
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
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void askPrizeNum() {
        System.out.println(Print.ASK_PRIZE);
        String prize = Input.inputPrize();
        PrizeNum.setPrizeNum(prize);
    }

    public static void askBonusNum() {
        System.out.println(Print.ASK_BONUS);
        String bonus = Input.inputBonus();
        PrizeNum.setBonusNum(bonus);
    }

    public static void printLottoStat() {
        System.out.println(Print.ANALYSE_PRIZE);
        Analyse.analyseLotto(lottos, PrizeNum.getPrize());

        stats = Analyse.getStats();

        for (Prize p : stats.descendingKeySet()) {
            System.out.println(p.getPrizePrint() + " - " + stats.get(p) + "개");
        }
    }

    public static void printLottoRate() {
        double rate = Analyse.rateLotto(lottos.size() * 1000);
        System.out.println(Print.RATE_BEFORE + String.format("%,.1f", Double.parseDouble(new BigDecimal(rate).toPlainString())) + Print.RATE_AFTER);
    }
}
