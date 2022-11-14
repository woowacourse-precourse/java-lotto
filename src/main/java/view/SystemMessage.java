package view;

import domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SystemMessage {

    private static final int RANK_COUNT = 6;
    private static final int INITIAL_COUNT = 0;

    static int FIFTH_CNT = 0;
    static int FOURTH_CNT = 0;
    static int THIRD_CNT = 0;
    static int SECOND_CNT = 0;
    static int FIRST_CNT = 0;

    public void requestTotalMoney(int money){
        System.out.println(money);
        System.out.println("");
    }

    public void ticketsMessage(int n){
        System.out.println(n + "개를 구매했습니다.");
    }

    public void ticketNumberMessage(List<Integer> lotto){
        String msg = "";
        msg += "[";
        for (int i = 0; i < lotto.size(); i++) {
            msg += lotto.get(i) + ",";
        }
        msg = msg.substring(0, msg.length() - 1);
        msg += "]";

        System.out.println(msg);
    }

    public void winningNumbersMessage(String input){
        System.out.println(input);
        System.out.println("");
    }

    public void bonusNumberMessage(String input){
        System.out.println(input);
        System.out.println("");
    }

    public void winningMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

//3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개

    public void countMessage(Map<Rank, Integer> map){
        System.out.println("3개 일치 (5,000원) - " + map.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000,000,000원) - " + map.get(Rank.FIRST) + "개");
    }

    public Map<Rank, Integer> getCount(Rank rank, Map<Rank, Integer> map) {
        map.put(rank, map.get(rank)+1);
        return map;
    }

    public Map<Rank, Integer> mapSetting(Map<Rank, Integer> map){
        map.put(Rank.FAIL, INITIAL_COUNT);
        map.put(Rank.FIFTH, INITIAL_COUNT);
        map.put(Rank.FOURTH, INITIAL_COUNT);
        map.put(Rank.THIRD, INITIAL_COUNT);
        map.put(Rank.SECOND, INITIAL_COUNT);
        map.put(Rank.FIRST, INITIAL_COUNT);

        return map;
    }
}
