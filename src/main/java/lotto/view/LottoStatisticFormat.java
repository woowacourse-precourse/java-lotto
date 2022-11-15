package lotto.view;

import java.text.DecimalFormat;

public class LottoStatisticFormat {

    private static final DecimalFormat moneyFormat = new DecimalFormat("###,###원");

    public static String addMatchNumber(int n) {
        return n + "개 일치";
    }

    public static String addWinningMoney(Long n) {
        return " (" + moneyFormat.format(n) + ")";
    }

    public static String addWinningCount(int n) {
        return " - " + n + "개";
    }

    public static String addBonusMatch() {
        return ", 보너스 볼 일치";
    }

    public static String addReturnRate(String str) {
        return "총 수익률은 " + str + "%입니다.";
    }
}
