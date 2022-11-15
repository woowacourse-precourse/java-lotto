package lotto.view;

import lotto.model.WinningRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class View {

    public static void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void printPurchaseList(List<List<Integer>> purchases) {
        System.out.println(purchases.size()+"개를 구매했습니다.");
        for (List<Integer> purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public static void printNeedWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printNeedBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(Map<WinningRank,Integer> winResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+winResult.getOrDefault(WinningRank.five,0)+"개");
        System.out.println("4개 일치 (50,000원) - "+winResult.getOrDefault(WinningRank.four,0)+"개");
        System.out.println("5개 일치 (1,500,000원) - "
                + winResult.getOrDefault(WinningRank.three, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                +winResult.getOrDefault(WinningRank.two,0)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winResult.getOrDefault(WinningRank.one,0)+"개");
    }

    public static void printEarningsRate(double rate) {
        DecimalFormat output = new DecimalFormat("###,###.#");
        System.out.println("총 수익률은 " + output.format(rate) + "%입니다.");
    }



}
