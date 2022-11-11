package view;

import constant.Statistics;
import domain.LottoGame;
import java.util.List;

public class PrintStatistics {

    public void printStatistcs(){

        List<Integer> rankedList = LottoGame.getRankedList();
        long sumMoney = LottoGame.getSumMoney();
        float yield = LottoGame.getYield();

        System.out.println("당첨 통계\n---");
        System.out.println(Statistics.LAST_RANKED.getStatistics() + rankedList.get(0)  +"개");

        System.out.println(Statistics.FOURTH_RANKED.getStatistics()+ rankedList.get(1)  +"개");

        System.out.println(Statistics.THIRD_RANKED.getStatistics()  + rankedList.get(2)  +"개");

        System.out.println(Statistics.SECOND_RANKED.getStatistics() + rankedList.get(4)  +"개");

        System.out.println(Statistics.FIRST_RANKED.getStatistics() + rankedList.get(3)  +"개");
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
    
}
