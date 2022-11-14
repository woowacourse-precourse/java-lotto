package lotto;

import java.util.LinkedList;
import java.util.List;
import constant.LottoRanking;
public class ResultCalculate {
    public static void resultCalculate(List<Lotto> purchaseLottos, List<Integer> drawLotto ){
        profitCalculate(synthesizeRanking(purchaseLottos,drawLotto));
    }
    public static List<Integer> synthesizeRanking(List<Lotto> purchaseLottos, List<Integer> drawLotto){
        List<Integer> ranks = new LinkedList<>();
        for(int i=0; i<6; i++){
            ranks.add(0);
        }
        for(Lotto lotto :purchaseLottos){
            int sameNumberCount = compareTwoNumbers(lotto, drawLotto);
            if(sameNumberCount != LottoRanking.NOTHING.getRanking())
                ranks.set(sameNumberCount,ranks.get(sameNumberCount)+1);
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
        if(sameNumberCount==LottoRanking.FIFTH.getSameNumberCount())
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
    public static void profitCalculate(List<Integer> Rankings){

    }
}
