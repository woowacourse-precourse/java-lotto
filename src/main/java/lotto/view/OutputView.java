package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import lotto.domain.Grade;
import lotto.domain.Lotto;

public class OutputView {
    private final static String INPUT_AMOUNT_MASSAGE = "구입금액을 입력해 주세요.";
    private final static String CHECK_AMOUNT_MASSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_NUMBERS_MASSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MASSAGE = "보너스 번호를 입력해 주세요.";
    private final static String WINNING_STATISTICS_MASSAGE = "당첨 통계";

    public static void printInputAmount() {
        System.out.println(INPUT_AMOUNT_MASSAGE);
    }

    public static void printCheckAmount(int amount) {
        System.out.printf(CHECK_AMOUNT_MASSAGE + "%n", amount);
    }

    public static void printPurchasedNumbers(List<Lotto> purchasedNumbers) {
        
        for (Lotto lotto : purchasedNumbers) {
            String s = "";
            s += "[";
            for (int i = 0; i < lotto.getNumbers().size(); i++) {
                if (i == lotto.getNumbers().size() - 1) {
                    s += lotto.getNumbers().get(i) + "]";
                } else {
                    s += lotto.getNumbers().get(i) + ", ";
                }
            }
            System.out.println(s);
        }
    }

    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MASSAGE);
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MASSAGE);
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MASSAGE);
    }

    // fix
    public static void printLottoStatics(Map<String, Integer> maps) {
        System.out.println("당첨 통계");
        System.out.println("---");

        maps.forEach((k, v) -> {
            Grade grade = Grade.findGradeByKey(k);

            if (k == "5+B") {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", grade.getMatchCount(),
                        NumberFormat.getCurrencyInstance(new Locale("ko", "KR")).format(grade.getPrizeMoney()).substring(1), v);
            }
            if (k != "5+B") {
                System.out.printf("%d개 일치 (%s원) - %d개%n", grade.getMatchCount(),
                        NumberFormat.getCurrencyInstance(new Locale("ko", "KR")).format(grade.getPrizeMoney()).substring(1), v);
            }
        });
    }

    public static void printLottoEarningRate(String yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}