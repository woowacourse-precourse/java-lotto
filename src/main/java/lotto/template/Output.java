package lotto.template;

public class Output {
    public static void showTicket() {
        System.out.println("2개를 구매했습니다.");
        System.out.println("[1,2,3,4,5,6]\n[11,12,13,14,15,16]");
    }

    public static void showWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(
                "3개 일치 (5,000원) - " + "1" + "개\n" +
                        "4개 일치 (50,000원) - " + "2" + "개\n" +
                        "5개 일치 (1,500,000원) - " + "3" + "개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - " + "4" + "개\n" +
                        "6개 일치 (2,000,000,000원) - " + "5" + "개\n" +
                        "총 수익률은 " + "100.0" + "%입니다."
        );
    }
}
