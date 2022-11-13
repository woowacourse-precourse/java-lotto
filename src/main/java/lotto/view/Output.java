package lotto.view;

public class Output {

    public static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String JACKPOT_NUM = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public static final String BOUGHT_NUM = "개를 구매했습니다.";
    public static void outputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public static void outputBoughtNumber(int volume) {
        System.out.println(volume + BOUGHT_NUM);
    }

    public static void outputJackpotNumber() {
        System.out.println(JACKPOT_NUM);
    }

    public static void outputBonusNumber() {
        System.out.println(BONUS_NUM);
    }

    public static void outputResult(int fifth, int fourth, int third, int second, int first) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public static void outputEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
