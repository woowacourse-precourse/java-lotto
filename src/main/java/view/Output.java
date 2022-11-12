package view;

import domain.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static view.Profit.*;

public class Output {
    private Input input;

    private Lottos lottos;

    private List<Integer> rankNumber; //1등~5등 각각 해당 로또 수

    private final static int unitPrice = 1000;

    private final static int changePercent = 100;

    private final static Profit[] rank = new Profit[]{One, Two, Three, Four, Five};

    public Output() {
        input = new Input();
        lottos = new Lottos(input.getNumber());
        rankNumber = Arrays.asList(0, 0, 0, 0, 0);
    }

    public void printLottoList() {
        System.out.println(lottos.getNumberOfLotto()+"개를 구매했습니다.");
        for (int i = 0; i < lottos.getNumberOfLotto(); i++) {
            System.out.println(lottos.getLottos().get(i));
        }
    }

    public int checkOneLottoRank(int index) {
        int count = (int) input.getAnswer().stream().filter(o -> lottos.getLottos().get(index).stream()
                .anyMatch(Predicate.isEqual(o))).count();
        int rank = 8 - count;
        if (count == 5 && lottos.getLottos().get(index).contains(input.getBonus())) {
            rank = 2;
        }
        if (count == 6) {
            rank = 1;
        }
        return rank;
    }

    public void setRankList() {
        for(int i = 0; i < lottos.getLottos().size(); i++) {
            if( checkOneLottoRank(i) <= 5) {
                rankNumber.set(checkOneLottoRank(i)-1, rankNumber.get(checkOneLottoRank(i)-1)+1);
            }
        }
    }

    public void printRank() {
        for(int i = 4; i >= 0; i--) {
            System.out.println(rank[i].getPrint()+" - " + rankNumber.get(i)+"개");
        }
    }

    public int calcProfitRate() {
        int entirePurchaseLotto = input.getNumber() * unitPrice;
        int entireProfit = 0;
        for (int i = 0; i < rank.length; i++) {
            entireProfit += rankNumber.get(i) * rank[i].getPrize();
        }
        return (entireProfit / entirePurchaseLotto) * changePercent;
    }

    public void printProfitRate() {
        System.out.println("총 수익률은 " + calcProfitRate() + "%입니다.");
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRank();
        printProfitRate();
    }
}
