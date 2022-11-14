package lotto;

import java.util.LinkedList;
import java.util.List;
import constant.LottoRanking;
public class ResultCalculate {
    public static void resultCalculate(List<Lotto> purchaseLottos, List<Integer> drawLotto ){
        List<Integer> ranks = new LinkedList<>();
        for(Lotto lotto :purchaseLottos){
            int sameNumberCount = compareTwoNumbers(lotto, drawLotto);
            ranks.set(sameNumberCount,ranks.get(sameNumberCount)+1); // List의 초기화가 필요한지.
        }
    }
    public static int compareTwoNumbers(Lotto lotto, List<Integer> drawLotto){
        int sameNumberCount = 7;
        for(int nowNumber:drawLotto){
            if(lotto.getNumbers().contains(nowNumber)){
                sameNumberCount--;
            }
        }
        if(sameNumberCount==2){
            if(lotto.getNumbers().contains(drawLotto.get(6))) {
                return LottoRanking.SECOND.getRanking();
            }
            return LottoRanking.THIRD.getRanking();
        }
        if(sameNumberCount==3)
            return LottoRanking.FOURTH.getRanking();
        return sameNumberCount;
    }
    public static void profitCalculate(){

    }
}
