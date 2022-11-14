package lotto;

import java.util.LinkedList;
import java.util.List;
import constant.LottoRanking;
import ui.ResultPrint;
public class ResultCalculate {
    public static void resultCalculate(List<Lotto> purchaseLottos, List<Integer> drawLotto,int buyAmount){
        profitCalculate(synthesizeRanking(purchaseLottos,drawLotto),buyAmount);
    }
    public static List<Integer> synthesizeRanking(List<Lotto> purchaseLottos, List<Integer> drawLotto){
        List<Integer> ranks = new LinkedList<>();
        for(int i=0; i<6; i++){
            ranks.add(0);
        }
        for(Lotto lotto :purchaseLottos){
            int ranking = compareTwoNumbers(lotto, drawLotto);
            int price =0;
            if(ranking != LottoRanking.NOTHING.getRanking()){
                price = calculatePrice(ranking);
                ranks.set(ranking,ranks.get(ranking)+1);
                ranks.set(LottoRanking.PRICE.getIndex(),ranks.get(LottoRanking.PRICE.getIndex())+price);
            }
        }
        return ranks;
    }
    public static int compareTwoNumbers(Lotto lotto, List<Integer> drawLotto){
        int sameNumberCount = 0;
        for(int nowNumber:drawLotto){
            if(lotto.getNumbers().contains(nowNumber)){
                sameNumberCount++;
            }
        }
        if(sameNumberCount<=LottoRanking.NOTHING.getSameNumberCount())
            return LottoRanking.NOTHING.getRanking();
        return calculateRanking(lotto, drawLotto,sameNumberCount);
    }
    private static int calculateRanking(Lotto lotto, List<Integer> drawLotto, int sameNumberCount){
        if(sameNumberCount==LottoRanking.FIRST.getSameNumberCount())
            return LottoRanking.FIRST.getRanking();
        if(sameNumberCount==LottoRanking.SECOND.getSameNumberCount()){
            if(lotto.getNumbers().contains(drawLotto.get(6))) {
                return LottoRanking.SECOND.getRanking();
            }
            return LottoRanking.THIRD.getRanking();
        }
        if(sameNumberCount==LottoRanking.FOURTH.getSameNumberCount())
            return LottoRanking.FOURTH.getRanking();
        return LottoRanking.FIFTH.getRanking();
    }
    private static int calculatePrice(int sameNumberCount){
        if(sameNumberCount==LottoRanking.FIRST.getRanking())
            return LottoRanking.FIRST.getPrice();
        if(sameNumberCount==LottoRanking.SECOND.getRanking())
            return LottoRanking.SECOND.getPrice();
        if(sameNumberCount==LottoRanking.THIRD.getRanking())
            return LottoRanking.THIRD.getPrice();
        if(sameNumberCount==LottoRanking.FOURTH.getRanking())
            return LottoRanking.FOURTH.getPrice();

        return LottoRanking.FIFTH.getPrice();
    }
    public static void profitCalculate(List<Integer> rankings, int outcome){
        ResultPrint.printResult(rankings);
        int income = rankings.get(LottoRanking.PRICE.getIndex());
        System.out.printf("총 수익률은 %.1f%%입니다.\n",calculatePercent(income,outcome));
    }

    public static double calculatePercent(int income,int outcome){
        double profitPercent = (((double)income*100)/(double)outcome);
        profitPercent = Math.round(profitPercent*10)/(double)10;
        return profitPercent;
    }
}
