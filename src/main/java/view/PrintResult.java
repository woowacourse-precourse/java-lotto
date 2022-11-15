package view;

import lotto.NumberMatch;

import java.util.HashMap;
import java.util.List;

public class PrintResult {
    private static final String UNIT = "개";

    public static void printBuyLotto(int buyLottoNumber){
        System.out.println(buyLottoNumber + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lottoNumber){
        System.out.println(lottoNumber);
    }

    public static void printMatchDetail(HashMap matchNumbers) {
        List<Integer> order = List.of(3, 4, 5, 7, 6);
        for (NumberMatch numberMatch : NumberMatch.values()) {
            int idx = 0;
            System.out.println(numberMatch.getNumberMatch() + matchNumbers.get(order.get(idx)) + UNIT);
        }
    }

    public static void printRevenue(int totalMoney, int lottoMoney) {
        int revenue = totalMoney / lottoMoney * 100;
        System.out.println(revenue);
    }
}
