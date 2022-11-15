package lotto;

import java.util.Iterator;
import java.util.Map;

public class RewardMessage {

    private static final String FIRST_MESSAGE ="6개 일치 (2,000,000,000원) - ";
    private static final String SECOND_MESSAGE ="5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String THIRD_MESSAGE ="5개 일치 (1,500,000원) - ";
    private static final String FOURTH_MESSAGE ="4개 일치 (50,000원) - ";
    private static final String FIVTH_MESSAGE ="3개 일치 (5,000원) - ";
    private static final String AMOUNT ="개";
    private static final String ALL_YIELD_MESSAGE_FRONT = "총 수익률은 ";
    private static final String ALL_YIELD_MESSAGE_BACK = "%입니다.";

    static void prizeMessage(Map<Rank,Integer> ranking){
        Iterator<Rank> iterator = ranking.keySet().iterator();
        while (iterator.hasNext()) {
            Rank key = iterator.next();
            int value = ranking.get(key);
            matchPrizeMessage(key,value);
        }
    }

    static void matchPrizeMessage(Rank key, int value) {
        if(key.equals(Rank.FIVE)){
            System.out.println(FIVTH_MESSAGE+value+AMOUNT);
        }
        if(key.equals(Rank.FOUR)){
            System.out.println(FOURTH_MESSAGE+value+AMOUNT);
        }
        if(key.equals(Rank.THIRD)){
            System.out.println(THIRD_MESSAGE+value+AMOUNT);
        }
        if(key.equals(Rank.SECOND)){
            System.out.println(SECOND_MESSAGE+value+AMOUNT);
        }
        if(key.equals(Rank.FIRST)){
            System.out.println(FIRST_MESSAGE+value+AMOUNT);
        }
    }
}
