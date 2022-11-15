package view;

import domain.Rank;
import utils.PrintMessage;

import java.util.List;
import java.util.Map;

public class PrintView{
    PrintMessage printMessage;

    public void printLotto(List<List<Integer>> lottoList) {
        System.out.println(lottoList.size() + printMessage.PURCHASE_INFO);
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public void printWinningResult(Map<Rank, Integer> result, double yield) {
        System.out.println(printMessage.STATISTIC_INFO);
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
        System.out.println(printMessage.TOTAL_PRIZE + yield + "%입니다.");
    }
}
