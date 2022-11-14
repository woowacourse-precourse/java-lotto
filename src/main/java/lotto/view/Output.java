package lotto.view;

import java.util.List;

public class Output {

    public static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String JACKPOT_NUM = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM = "보너스 번호를 입력해 주세요.";
    public static final String BOUGHT_NUM = "개를 구매했습니다.";
    public static final String TOTAL_EARN = "총 수익률은 ";
    public static final String PERCENT = "%입니다.";
    public static final String TOTAL_STAT = "당첨 통계";
    public static final String DASH = "---";
    public static final String THREE_MATCH = "3개 일치 (5,000원) - ";
    public static final String FOUR_MATCH = "4개 일치 (50,000원) - ";
    public static final String FIVE_MATCH = "5개 일치 (1,500,000원) - ";
    public static final String FIVE_AND_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - ";
    public static final String COUNT = "개";

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
        System.out.println(TOTAL_STAT);
        System.out.println(DASH);
        System.out.println(THREE_MATCH+ fifth + COUNT);
        System.out.println(FOUR_MATCH + fourth + COUNT);
        System.out.println(FIVE_MATCH + third + COUNT);
        System.out.println(FIVE_AND_BONUS + second + COUNT);
        System.out.println(SIX_MATCH + first + COUNT);
    }

    public static void outputEarningRate(String earningRate) {
        System.out.println(TOTAL_EARN + earningRate + PERCENT);
    }

    public static void lottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
