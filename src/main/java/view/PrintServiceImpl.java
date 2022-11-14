package view;

import domain.Statistics;
import message.PrintMessage;

import java.util.List;
import java.util.Map;

public class PrintServiceImpl implements PrintService{
    PrintMessage printMessage;

    @Override
    public void printLotto(List<List<Integer>> lottoList) {
        System.out.println(lottoList.size() + printMessage.PURCHASE_INFO);
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printWinningResult(Map<Statistics, Integer> result, double yield) {
        System.out.println(printMessage.STATISTIC_INFO);
        System.out.println("---");
        for (Statistics rank : Statistics.values()) {
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
        System.out.println(printMessage.TOTAL_PRIZE + yield + "%입니다.");
    }
}