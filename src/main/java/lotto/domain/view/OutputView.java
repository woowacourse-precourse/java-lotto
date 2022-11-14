package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.OutputResult;
import lotto.global.constant.OutputViewConstants;
import lotto.global.constant.VerifierConstants;
import lotto.global.util.Util;

import java.text.DecimalFormat;
import java.util.Map;

import static lotto.global.constant.OutputViewConstants.*;


public class OutputView {

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
            String message = getMessage(messageInfo);
            String benefit = getBenefit(messageInfo);
            int bonus = getBonus(messageInfo);
            int proxy = getProxyNumber(i);

            totalBenefit += treatBenefit(messageInfo, result, proxy, bonus, totalBenefit);
            System.out.println(returnResultValue(message, benefit, proxy, bonus, result));
        }
        return totalBenefit;
    }

    private static String getMessage(Map<String, String> messageInfo) {
        return messageInfo.get(OutputViewConstants.message);
    }

    private static String getBenefit(Map<String, String> messageInfo) {
        return Util.decimalFormatting(Long.parseLong(messageInfo.get(OutputViewConstants.benefit)));
    }

    private static int getBonus(Map<String, String> messageInfo) {
        return Integer.parseInt(messageInfo.get(OutputViewConstants.bonus));
    }

    private static double treatBenefit(Map<String, String> messageInfo, Map<String, Integer> result, int proxy, int bonus, double totalBenefit) {
        Integer count = result.get(String.format(MATCH_COUNT, proxy, bonus));
        if (count != null) {
            totalBenefit += isValuePresentPlusTotal(result.get(String.format(MATCH_COUNT, proxy, bonus)), messageInfo);
            return totalBenefit;
        }
        return 0;
    }

    private static String returnResultValue(String message, String benefit, int proxy, int bonus, Map<String, Integer> result) {
        String printResult = null;

        printResult = String.format(message, benefit, result.get(String.format(MATCH_COUNT, proxy, bonus)));
        if (result.get(String.format(MATCH_COUNT, proxy, bonus)) == null) {
            printResult = String.format(message, benefit, 0);
        }

        return printResult;
    }

    private static double isValuePresentPlusTotal(int count, Map<String, String> messageInfo) {
        double plusTotalValue = 0;
        for (int i = 0; i < count; i++) {
            plusTotalValue += Double.parseDouble(messageInfo.get(benefit));
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
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMATTER);
        System.out.println("총 수익률은 " + decimalFormat.format(grossEarnings) + "%입니다.");
    }

    public static void printError(String message) {
        System.out.println(VerifierConstants.ERROR + message);
    }
}