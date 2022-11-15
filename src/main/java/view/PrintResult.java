package view;

import lotto.NumberMatch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PrintResult {
    private static final String UNIT = "개";

    public static void printBuyLotto(int buyLottoNumber){
        System.out.println(buyLottoNumber + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lottoNumber){
        lottoNumber.sort(Comparator.naturalOrder());
        System.out.println(lottoNumber);
    }

    public static void printMatchDetail(HashMap matchNumbers) {
        for (NumberMatch numberMatch : NumberMatch.values()) {
            System.out.println(numberMatch.getNumberMatch() + matchNumbers.get(numberMatch.getOrder()) + UNIT);
        }
    }

    public static void printRevenue(int totalMoney, int lottoMoney) {
        float revenue = totalMoney / (float) lottoMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", revenue) + "%입니다.");
    }
}
