package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.OutputResult;
import lotto.global.util.Util;

import java.text.DecimalFormat;
import java.util.Map;

import static lotto.global.constant.OutputViewConstants.*;


public class OutputView {
    private static int BONUS = 0;
    private static String MATCH_COUNT = "일치하는 볼 개수 %d개, 보너스 볼 개수 %d개";

    public static void printCountByBuyLotto(int lottoCount) {
        System.out.printf((BUY_LOTTO) + "%n", lottoCount);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void enter() {
        System.out.println();
    }

    public static String printInputPrizeNumbers() {
        enter();
        System.out.println(INPUT_PRIZE_NUMBERS);
        return Util.input();
    }

    public static void printDividingLine() {
        enter();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDE_LINE);
    }

    public static Double printResult(Map<String, Integer> result) {
        double totalBenefit = 0;
        for (int i = 3; i < 8; i++) {
            isI6SaveBonus1OrElseSaveBonus0(i);
            Map<String, String> messageInfo = createMessage(i);

            String message = messageInfo.get("message");
            String benefit = Util.decimalFormatting(Long.parseLong(messageInfo.get("benefit")));
            int bonus = Integer.parseInt(messageInfo.get("bonus"));

            int proxy = getProxyNumber(i);
            Integer count = result.get(String.format(MATCH_COUNT, proxy, bonus));
            if (count != null) {
                totalBenefit += isValuePresentPlusTotal(proxy, bonus, result.get(String.format(MATCH_COUNT, proxy, bonus)), messageInfo);
            }

            System.out.println(returnResultValue(message, benefit, proxy, bonus, result));
        }
        return totalBenefit;
    }

    private static String returnResultValue(String message, String benefit, int proxy, int bonus, Map<String, Integer> result) {
        String printResult = null;

        printResult = String.format(message, benefit, result.get(String.format(MATCH_COUNT, proxy, bonus)));
        if (result.get(String.format(MATCH_COUNT, proxy, bonus)) == null) {
            printResult = String.format(message, benefit, 0);
        }

        return printResult;
    }

    private static double isValuePresentPlusTotal(int proxy, int bonus, int count, Map<String, String> messageInfo) {
        double plusTotalValue = 0;
        for (int i = 0; i < count; i++) {
            plusTotalValue += Double.parseDouble(messageInfo.get("benefit"));
        }

        return plusTotalValue;
    }

    private static void isI6SaveBonus1OrElseSaveBonus0(int i) {
        if (i != 6) {
            BONUS = 0;
        }
        if (i == 6) {
            BONUS = 1;
        }
    }

    private static int getProxyNumber(int i) {
        int proxy = i;
        if (i == 6 || i == 7) {
            proxy -= 1;
        }
        return proxy;
    }

    private static Map<String, String> createMessage(int prize) {
        assert OutputResult.getMessage(prize, BONUS) != null;
        return OutputResult.getMessage(prize, BONUS);
    }

    public static void printGrossEarnings(double grossEarnings) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        System.out.println("총 수익률은 " + decimalFormat.format(grossEarnings) + "% 입니다.");
    }
}
