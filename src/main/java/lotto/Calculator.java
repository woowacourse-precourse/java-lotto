package lotto;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private static HashMap<Integer,Integer> prizeBuckets=Util.setPrizeBuckets();
    private static HashMap<Integer,Integer> prizeInfo= Util.setPrizeInfo();;
    private static final List<Integer> scoreOrder=List.of(3,4,5,-1,6);;
    private static final List<String> moneyOrder=List.of("5,000","50,000","1,500,000","","2,000,000,000");;

    public static void calculateLotto(List<Lotto> lottoBuckets, Lotto userLotto ,int bonus){
        for(Lotto lotto : lottoBuckets){
            int corretNum = userLotto.compare(lotto);
            if((corretNum>2 && corretNum <5) || corretNum==6){
                prizeBuckets.put(corretNum,prizeBuckets.get(corretNum)+1);
            }
            if(corretNum==5&&!lotto.containBonus(bonus)){
                prizeBuckets.put(corretNum,prizeBuckets.get(corretNum)+1);
            }
            if(corretNum==5&&lotto.containBonus(bonus)) {
                prizeBuckets.put(-1,prizeBuckets.get(corretNum)+1);
            }
        }
    }
    public static void printLotto(List<Lotto> lottoBuckets, Lotto userLotto ,int bonus,int buyLottoCount){
        int benefit = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int order=0;order<5;order++){
            int key = scoreOrder.get(order);
            if(key==-1){
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+prizeBuckets.get(-1)+"개");
            }
            if(key>-1){
                System.out.println(key+"개 일치 ("+moneyOrder.get(order)+"원) - "+prizeBuckets.get(key)+"개");
            }
            benefit+=prizeInfo.get(key)*prizeBuckets.get(key);
        }
        System.out.println("총 수익률은 "+String.format("%.1f", (double)((double)benefit/(double)(buyLottoCount*1000))*(double)100)+"%입니다.");
    }
}
