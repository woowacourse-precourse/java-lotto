package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInterface {
    private static final List<String> PRIZE = Arrays.asList("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH");
    private static final String MONEY_UI = "구입금액을 입력해주세요.";
    private static final String PURCHASE_UI = "개를 구매했습니다.";
    private static final String WIN_NUMBERS_UI = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_UI = "보너스 번호를 입력해주세요";
    private static final String RESULT_UI = "당첨 통계\n---";
    private static final String RATE_UI_1 = "총 수익률은 ";
    private static final String RATE_UI_2 = "%입니다.";

    public static String readMoney() {
        System.out.println(MONEY_UI);
        return Console.readLine();
    }

    public static String readWinNumbers() {
        System.out.println(WIN_NUMBERS_UI);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_UI);
        return Console.readLine();
    }

    public static void printLottoNumbers(List<Lotto> numbers) {
        System.out.println(numbers.size() + PURCHASE_UI);
        for (Lotto num : numbers) {
            System.out.println(num);
        }
    }

    public static void printResult(Customer customer) {
        System.out.println(RESULT_UI);
        List<Integer> winningCount = customer.getWinningCount();
        for (int i = winningCount.size() - 1; i >= 0; i--) {
            String result = "";
            PrizeCode prizeCode = PrizeCode.valueOf(PRIZE.get(i));
            result += prizeCode.getCondition() + " ";
            result += "(" + String.format("%,d", prizeCode.getReward()) + "원)";
            result += " - " + String.valueOf(winningCount.get(i)) + "개";
            System.out.println(result);
        }
    }

    public static void printRate(Customer customer) {
        System.out.println(RATE_UI_1 + String.format("%.1f", customer.getRate()) + RATE_UI_2);
    }
}
