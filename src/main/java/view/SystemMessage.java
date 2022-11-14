package view;

import domain.Rank;

import java.util.List;
import java.util.Map;

public class SystemMessage {

    private int money;

    public void requestTotalMoney(int money){
        System.out.println(money);
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

    public void getResultMessage(Map<Rank, Integer> map){
        StringBuilder stringBuilder = new StringBuilder();
        winningMessage();
        countMessage(stringBuilder, map);
        System.out.println(stringBuilder);
    }

    public void winningMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public String getBonus(Rank rank){
        if(rank.isBonus() == true){
            return ", 보너스 볼 일치";
        }
        return "";
    }

//3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
    public void countMessage(StringBuilder stringBuilder, Map<Rank, Integer> map){
        for(Rank rank : Rank.getRank()){
            stringBuilder.append(rank.getCount());
            stringBuilder.append("개 일치");
            stringBuilder.append(getBonus(rank));

            stringBuilder.append("(");
            stringBuilder.append(rank.getReward()).append("원) - ");
            stringBuilder.append(getCount(map, rank));
            stringBuilder.append("개");
            stringBuilder.append(System.lineSeparator());
        }
    }

    public static int getCount(Map<Rank, Integer> map, Rank rank){
        if(map.containsKey(rank)){
            return map.get(rank);
        }
        return 0;
    }

}
