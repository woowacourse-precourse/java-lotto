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
}
