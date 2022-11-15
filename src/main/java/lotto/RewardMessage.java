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

    static int lottoReward(Map<Rank,Integer> ranking){
        Iterator<Rank> iterator = ranking.keySet().iterator();
        int sum =0;
        while (iterator.hasNext()) {
            Rank key = iterator.next();
            int value = ranking.get(key);
            sum += sumReward(key,value,0);
        }
        return sum;
    }

    static int sumReward(Rank key,int value, int money){

        if(key.equals(Rank.FIVE)){
            money = (Rank.FIVE.getReward())*value;
        }
        if(key.equals(Rank.FOUR)){
            money = (Rank.FOUR.getReward())*value;
        }
        if(key.equals(Rank.THIRD)){
            money = (Rank.THIRD.getReward())*value;
        }
        if(key.equals(Rank.SECOND)){
            money = (Rank.SECOND.getReward())*value;
        }
        if(key.equals(Rank.FIRST)){
            money = (Rank.FIRST.getReward())*value;
        }
        return money;
    }

    static String lottoYield(int buyLottoMoney, int sumReward){
        double yield = ((double) sumReward / (double) buyLottoMoney)*100.0;
        return String.format("%.1f",yield);
    }
    static void yieldMessage(int buyLottoMoney, int sumReward){
        String yield = lottoYield(buyLottoMoney,sumReward);
        System.out.println(ALL_YIELD_MESSAGE_FRONT+yield+ALL_YIELD_MESSAGE_BACK);
    }
}
