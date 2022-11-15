package lotto.view;

import lotto.domain.Grade;
import lotto.domain.Lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OutputView {
    private static final String INPUT_AMOUNT_MASSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_AMOUNT_MASSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MASSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MASSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MASSAGE = "당첨 통계";

    public static void printInputAmount() {
        System.out.println(INPUT_AMOUNT_MASSAGE);
    }

    public static void printCheckAmount(int amount) {
        System.out.printf(CHECK_AMOUNT_MASSAGE + "%n", amount);
    }
    public static void printPurchasedNumbers(List<Lotto> purchasedNumbers) {
        for (Lotto lotto : purchasedNumbers) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MASSAGE);
    }
    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MASSAGE);
    }

    public static void printLottoStatics(Map<String, Integer> maps) {
        System.out.println(WINNING_STATISTICS_MASSAGE);
        System.out.println("---");

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("ko", "KR"));
        maps.forEach((k, v) -> {
            Grade grade = Grade.findGradeByKey(k);
            String formattedPrize = numberFormat.format(
                    grade.getPrizeMoney()).substring(1);
            if (k != Grade.SECOND.getKey()) {
                System.out.printf("%d개 일치 (%s원) - %d개%n", grade.getMatchCount(), formattedPrize, v);
            }
            if (k == Grade.SECOND.getKey()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", grade.getMatchCount(), formattedPrize, v);
            }
        });
    }
    public static void printLottoEarningRate(String yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }

}
