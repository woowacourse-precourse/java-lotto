package lotto.view;

public class OutputLottoView {
    private static final String HOW_MUCH_PURCHASE = "개를 구매했습니다.";
    private static final String WIN_STAT = "당첨 통계";
    private static final String MAKE_LINE = "---";
    private static final String FIT_THREE = "3개 일치 (5,000원) - ";
    private static final String FIT_FOUR = "4개 일치 (50,000원) - ";
    private static final String FIT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String FIT_FIVE_AND_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIT_ALL = "6개 일치 (2,000,000,000원) - ";
    private static final String RATE_OF_EARN = "총 수익률은 ";
    private static final String IT_IS = "%입니다.";
    private static final String COUNT = "개";
    private static final int MAX_LOTTO_NUMBERS = 6;
    private static final int[] LOTTO_MONEY = {2000000000, 30000000, 1500000, 50000, 5000};

    public static void printHowMuchPurchase(int howMuch) {
        System.out.println(howMuch + HOW_MUCH_PURCHASE);
    }

    public static void printWinStat(int[] ranks, int runMoney) {

        System.out.println(WIN_STAT);
        System.out.println(MAKE_LINE);
        System.out.println(FIT_THREE + ranks[5] + COUNT);
        System.out.println(FIT_FOUR + ranks[4] + COUNT);
        System.out.println(FIT_FIVE + ranks[3] + COUNT);
        System.out.println(FIT_FIVE_AND_BONUS + ranks[2] + COUNT);
        System.out.println(FIT_ALL + ranks[1] + COUNT);
        System.out.println(RATE_OF_EARN + earnMoney(ranks, runMoney) + IT_IS);
        System.out.println();
    }

    private static double earnMoney(int[] ranks, int runMoney) {
        double earn = 0;
        for (int i = 0; i < MAX_LOTTO_NUMBERS - 1; i++) {
            earn += LOTTO_MONEY[i] * ranks[i + 1];
        }


        earn /= runMoney;
        earn *= 100;
        earn = Math.round(earn * 10) / 10.0;
        //System.out.println(earn);
        return earn;
    }
}
