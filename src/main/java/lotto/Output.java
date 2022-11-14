package lotto;

import java.util.List;

public class Output {

    public static void printAll(Gambler person){
        System.out.println(person.gamblerLotto.size() + "개를 구매했습니다.");
        person.printAllLotto();
    }

    public static double getEarningRate(List<Integer> placeResult, Gambler person){
        int totalPrize = 0;
        for (int i=0;i<placeResult.size() - 1;i++){
            totalPrize = totalPrize + PrizeMoney.values()[i].amount * placeResult.get(i);
        }
        return (double) (totalPrize * 100) / person.CurrentMoney;
    }

    public static void printStatistic(List<Integer> placeResult, double earningRate){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i=4;i>-1;i--){
            String currentPlace = placeResult.get(i).toString();
            System.out.println(StatisticComment.values()[i].comment + currentPlace + "개");
        }
        System.out.println("총 수익률은 "+ String.format("%.1f", earningRate) + "%입니다.");
    }
}
