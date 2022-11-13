package lotto;

import java.util.List;
import java.util.Map;

public class PrintServiceImpl implements PrintService{
    PrintMessage printMessage;

    @Override
    public void printLotto(List<List<Integer>> lottoList) {
        System.out.println(lottoList.size() + String.valueOf(printMessage.PURCHASE_INFO));
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printWinningResult(Map<Rank, Integer> result, long yield) {
        System.out.println(String.valueOf(printMessage.STATISTIC_INFO));
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
        System.out.println(String.valueOf(printMessage.TOTAL_PRIZE) + yield + "%입니다.");
    }
}
