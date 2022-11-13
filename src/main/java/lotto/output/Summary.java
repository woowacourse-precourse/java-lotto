package lotto.output;

enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final long prize;

    Prize(long prize) {
        this.prize = prize;
    }

    public long getPrize() {
        return this.prize;
    }
}

public class Summary {

    public static void showResult(int first, int second, int third, int fourth, int fifth) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) -  %d개", fifth);
        System.out.println();
        System.out.printf("4개 일치 (50,000원) -  %d개", fourth);
        System.out.println();
        System.out.printf("5개 일치 (1,500,000원) -  %d개", third);
        System.out.println();
        System.out.printf("5개 일치, 보너스 볼 일치치 (30,000,000원) -  %d개", second);
        System.out.println();
        System.out.printf("6개 일치 (2,000,000,000원)  -  %d개", first);
    }

    public static void showEarning(int purchaseAmount, int first, int second, int third, int fourth, int fifth) {
        int prizeMoney = 0;

        prizeMoney += first * Prize.FIRST.getPrize();
        prizeMoney += second * Prize.SECOND.getPrize();
        prizeMoney += third * Prize.THIRD.getPrize();
        prizeMoney += fourth * Prize.FOURTH.getPrize();
        prizeMoney += fifth * Prize.FIFTH.getPrize();

        float f = (float) (prizeMoney / purchaseAmount * 1_000) * 100;
        System.out.println();
        System.out.println("총 수익률은 " + String.format("%.1f", f) + "%입니다.");
    }
}
