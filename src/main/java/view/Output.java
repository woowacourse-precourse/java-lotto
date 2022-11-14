package view;

import domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static view.Rank.*;

public class Output {
    private final List<Integer> rankNumber; //1등~5등 각각 해당 로또 수

    private final static int unitPrice = 1000;

    private final static int unitPercent = 100;

    private final static Rank[] rank = new Rank[]{One, Two, Three, Four, Five};

    public Output() {
        rankNumber = Arrays.asList(0, 0, 0, 0, 0);
    }

    public void printLottoList(List<List<Integer>> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public int checkOneLottoRank(List<Integer> answer, int bonus, List<List<Integer>> lottos, int index) {
        int count = (int) answer.stream().filter(o -> lottos.get(index).stream()
                .anyMatch(Predicate.isEqual(o))).count();
        int rank = 8 - count;
        if (count == 5 && lottos.get(index).contains(bonus)) {
            rank = 2;
        }
        if (count == 6) {
            rank = 1;
        }
        return rank;
    }

    public void setRankList(List<List<Integer>> lottos, List<Integer> answer, int bonus) {
        for(int i = 0; i < lottos.size(); i++) {
            if( checkOneLottoRank(answer, bonus, lottos, i) <= 5) {
                rankNumber.set(checkOneLottoRank(answer, bonus, lottos, i)-1,
                        rankNumber.get(checkOneLottoRank(answer, bonus, lottos, i)-1)+1);
            }
        }
    }

    public void printRank() {
        for(int i = 4; i >= 0; i--) {
            System.out.println(rank[i].getPrint()+" - " + rankNumber.get(i)+"개");
        }
    }

    public double calcProfitRate(int number) {
        double entirePurchaseLotto = number * unitPrice;
        double entireProfit = 0;
        for (int i = 0; i < rank.length; i++) {
            entireProfit += rankNumber.get(i) * rank[i].getPrize();
        }
        String profitRateRaw = String.format("%.1f",(entireProfit/entirePurchaseLotto)*unitPercent);
        return Double.parseDouble(profitRateRaw);
    }

    public void printProfitRate(int number) {
        System.out.println("총 수익률은 " + calcProfitRate(number) + "%입니다.");
    }

    public void printResult(int number) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRank();
        printProfitRate(number);
    }
}
