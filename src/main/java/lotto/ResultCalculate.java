package lotto;

import java.util.List;
public class ResultCalculate {
    public static void resultCalculate(List<Lotto> purchaseLottos, List<Integer> drawLotto ){
        for(Lotto lotto :purchaseLottos){
            compareTwoNumbers(lotto, drawLotto);
        }
    }
    public static int compareTwoNumbers(Lotto lotto, List<Integer> drawLotto){
        int sameNumberCount =0;
        for( int nowNumber:drawLotto){
            if(lotto.getNumbers().contains(nowNumber)){
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }
    public static void profitCalculate(){

    }
}
