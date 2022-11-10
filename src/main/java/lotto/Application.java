package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Output.askBuy();

            Output.answerBuy();

            Output.printLotto();

            Output.askPrizeNum();

            Output.askBonusNum();

//            System.out.println(Print.ASK_PRIZE);
//            List<Integer> prize = getPrize();
//
//            analyseLotto(Output.lottos, prize);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void analyseLotto(List<Lotto> lottos, List<Integer> prize) {
        TreeMap<Prize, Integer> stats = setStats();

        for (Lotto lotto : lottos) {
            countSameNum(lotto, prize, stats);
        }

        stats.remove(Prize.ZERO);
        printLottoStat(stats);

        long total = getTotalPrizeWon(stats);
        System.out.println("total: "+total);
        int budget = lottos.size() * 1000;
        System.out.println("budget: "+budget);

        double rate = (double) total/budget;
        System.out.println("rate: "+rate);
        rate = Math.round(rate*1000)/10.0;
        System.out.println(Print.RATE_BEFORE + rate + Print.RATE_AFTER);
    }

    private static void printLottoStat(TreeMap<Prize, Integer> stats) {
        System.out.println(Print.ANALYSE_PRIZE);
        for (Prize p : stats.descendingKeySet()) {
            System.out.println(p.getPrizePrint() + " - " + stats.get(p) + "개");
        }
    }

    private static long getTotalPrizeWon(TreeMap<Prize, Integer> stats) {
        long prizeWon = 0L;

        for(Prize p : stats.descendingKeySet()) {
            prizeWon += p.getPrizeWon() * stats.get(p);
        }

        return prizeWon;
    }

    private static TreeMap<Prize, Integer> setStats() {
        TreeMap<Prize, Integer> stats = new TreeMap<>();

        stats.put(Prize.FIRST, 0);
        stats.put(Prize.SECOND, 0);
        stats.put(Prize.THIRD, 0);
        stats.put(Prize.FOURTH, 0);
        stats.put(Prize.FIFTH, 0);
        stats.put(Prize.ZERO, 0);

        return stats;
    }

    private static void countSameNum(Lotto lotto, List<Integer> prize, TreeMap<Prize, Integer> stats) {
        int count = 0;
        List<Integer> lottoNum = lotto.getNumbers();

        for(int i=0; i<prize.size()-1; i++) {
            if(lottoNum.contains(prize.get(i))) {
                count++;
            }
        }

        if(count==5 && lottoNum.contains(prize.get(6))) {
            stats.replace(Prize.SECOND, stats.get(Prize.SECOND)+1);
            return;
        }

        Prize prizeName = Prize.findPrize(count);
        stats.replace(prizeName, stats.get(prizeName)+1);
    }

}
