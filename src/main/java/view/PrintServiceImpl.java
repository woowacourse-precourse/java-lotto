package view;

import domain.Statistics;
import messages.InfoMessages;

import java.util.List;
import java.util.Map;

public class PrintServiceImpl implements PrintService{
    InfoMessages infoMessages;

    @Override
    public void printLotto(List<List<Integer>> lottoList) {
        System.out.println(lottoList.size() + infoMessages.PURCHASE_INFO);
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printWinningResult(Map<Statistics, Integer> result, double yield) {
        System.out.println(infoMessages.STATISTIC_INFO);
        System.out.println("---");
        for (Statistics statistics : Statistics.values()) {
            System.out.println(statistics.getMessage() + result.get(statistics) + "개");
        }
        System.out.println(infoMessages.TOTAL_PRIZE + yield + "%입니다.");
    }
}