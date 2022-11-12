package lotto;

import java.util.List;

public class OutputView {
    private long totalEarnMoney;
    private int purchaseAmount;
    public OutputView(List<Integer> statistics, int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        System.out.println("당첨 통계");
        System.out.println("---");
        resultThree(statistics.get(0));
        resultFour(statistics.get(1));
        resultFive(statistics.get(2));
        resultFiveBonus(statistics.get(3));
        resultSix(statistics.get(4));

        totalEarn();
    }
    private void resultThree(int result) {
        totalEarnMoney += result * 5000L;
        System.out.println("3개 일치 (5,000원) - " + result + "개");
    }
    private void resultFour(int result) {
        totalEarnMoney += result * 50000L;
        System.out.println("4개 일치 (50,000원) - " + result + "개");
    }
    private void resultFive(int result) {
        totalEarnMoney += result * 1500000L;
        System.out.println("5개 일치 (1,500,000원) - " + result +"개");
    }
    private void resultFiveBonus(int result) {
        totalEarnMoney += result * 30000000L;
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result + "개");
    }
    private void resultSix(int result) {
        totalEarnMoney += result * 2000000000L;
        System.out.println("6개 일치 (2,000,000,000원) - " + result + "개");
    }

    private void totalEarn() {
        System.out.printf("총 수익률은 %.1f%%입니다.", calculator());
    }
    private double calculator() {
        return totalEarnMoney / (double) purchaseAmount * 100;
    }
}
