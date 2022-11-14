package lotto.player;

import static lotto.util.Rank.RANK1;
import static lotto.util.Rank.RANK2;
import static lotto.util.Rank.RANK3;
import static lotto.util.Rank.RANK4;
import static lotto.util.Rank.RANK5;
import static lotto.util.Rank.RANK_NONE;

import java.util.LinkedHashMap;
import lotto.data.Lotto;
import lotto.util.Rank;

public class House {
    private final Lotto win;
    public House(Lotto win) {
        this.win = win;
    }


    public void printResultOf(User user){
        LinkedHashMap<Rank,Integer> statistic = new LinkedHashMap<>(){{
            put(RANK5, 0);
            put(RANK4, 0);
            put(RANK3, 0);
            put(RANK2, 0);
            put(RANK1, 0);
        }};

        for(Lotto ticket:user.tickets){
            Rank result = win.checkRankOf(ticket);
            if(result == RANK_NONE) continue;
            statistic.put(result, statistic.get(result)+1);
        }

        System.out.println("당첨통계");
        System.out.println("---");
        for (Rank key : statistic.keySet())
            System.out.println(key.getLabel() + " - " + statistic.get(key) + "개");
    }

    public void printRevenueOf(User user){
        int payment = user.getTicketNum() * 1000;
        int amount = 0;
        for(Lotto ticket:user.tickets){
            Rank result = win.checkRankOf(ticket);
            if(result == RANK_NONE) continue;
            amount += result.getMoney();
        }
        double revenue = amount / (double)payment * 100;
        System.out.println("총 수익률은 " + (Math.round(revenue * 100) / 100.0) + "%입니다.");
    }
}
