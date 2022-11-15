package lotto.constant;

public enum RankInfo {
    WIN_5(5000, "3개 일치 (5,000원) - "),
    WIN_4(50000, "4개 일치 (50,000원) - "),
    WIN_3(1500000, "5개 일치 (1,500,000원) - "),
    WIN_2(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WIN_1(2000000000, "6개 일치 (2,000,000,000원) - ");

    public final int prizeMoney;
    public final String message;

    RankInfo(int prizeMoney, String message) {
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static void printTotalPrizeRate(double totalRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalRate);
    }
}
