package view;

import constant.Statistics;
import domain.LottoGame;
import java.util.List;

public class OutputView {



    public static void printButMoney(){
        System.out.println("구입 금액을 입력해주세요.");
    }
    public static void printInputLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }


    public static void printException(Exception e){
        System.out.println(e.getMessage());
    }

    public static void printLottoList(int count, List<List<Integer>> printList){
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> lottoList : printList) {
            System.out.println(lottoList);
        }
    }

    public static void printStatistics() {
        List<Integer> rankedList = LottoGame.getRankedList();
        long sumMoney = LottoGame.getSumMoney();
        float yield = LottoGame.getYield();
        System.out.println("당첨 통계\n---");
        System.out.println(Statistics.LAST_RANKED.getStatistics() + rankedList.get(0) + "개");
        System.out.println(Statistics.FOURTH_RANKED.getStatistics() + rankedList.get(1) + "개");
        System.out.println(Statistics.THIRD_RANKED.getStatistics() + rankedList.get(2) + "개");
        System.out.println(Statistics.SECOND_RANKED.getStatistics() + rankedList.get(4) + "개");
        System.out.println(Statistics.FIRST_RANKED.getStatistics() + rankedList.get(3) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
