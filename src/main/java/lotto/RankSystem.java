package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class RankSystem {

    private static int winningMinCount = 3;
    private static int winningMaxCount = 6;
    private static int winningBonusCount = Rank.rank7.getCount();

    private float sumPrize;
    private int place;
    private String prize;
    private int count;

    public void hasPrintCount(List<Integer> countPrize){
        sumPrize=0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank:
             Rank.values()) {
            printNumber(rank,countPrize);
        }
    }

    private void printNumber(Rank rank,List<Integer> countPrize) {
        if(rank.getCount()>=winningMinCount&&rank.getCount()<=winningMaxCount){
            getRankValue(rank,countPrize);
            System.out.println(String.format("%d개 일치 (%s원) - %d개",place,prize,count));
        } else if (rank.getCount()==winningBonusCount) {
            getRankValue(rank,countPrize);
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",place,prize,count));
        }
    }
    public void getRankValue(Rank rank,List<Integer> countPrize){
        place = rank.getPlace();
        prize = numberPositionComma(rank.getPrize());
        count = Collections.frequency(countPrize, rank.getCount());
        sumPrize+=(count*rank.getPrize());
    }
    public String numberPositionComma(int count){
        return new DecimalFormat("#,##0").format(count);
    }

    public void calYield(int buyMoney){

        float yield = sumPrize/buyMoney*100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",yield));

    }

    //    public List<Integer> hasRanking(List<Integer> counting) {
//
//        return countPrize = new ArrayList<>(counting);
//        for (int counts:
//             counting) {
//                countPrize=new ArrayList<>();
//                OptionalInt countCheck = hasCountCheck(counts);
//                Optional.ofNullable(countCheck).ifPresent(
//
//                        n->countPrize.add(countCheck.getAsInt())
//                );
//        }
//        return countPrize;

//    }
//    public OptionalInt hasCountCheck(int counts){
//        for (Rank rank:
//                Rank.values()) {
//            if (rank.getCount() == counts) {
//                return OptionalInt.of(rank.getPlace());
//            }
//        }
//        return null;
//    }


}
