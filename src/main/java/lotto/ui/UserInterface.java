package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lotto.constant.WinningResult;

public class UserInterface {
    private static final String INPUT_MONEY_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private static final String PUBLISH_LOTTOS_ANNOUNCEMENT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_ANNOUNCEMENT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_ANNOUNCEMENT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_ANNOUNCEMENT = "당첨 통계\n---";
    private static final String YIELD_FORMAT_ANNOUNCEMENT =  "총 수익률은 %s%%입니다.";
    private static final String INPUT_MONEY_PATTERN = "^[1-9]+[0-9]{3,8}+$";

    public static String getInputMoney() {
        System.out.println(INPUT_MONEY_ANNOUNCEMENT);
        String inputMoneyRaw = Console.readLine();
        checkInputMoney(inputMoneyRaw);
        return inputMoneyRaw;
    }

    public static void announceCountOfLottosPublished(int countOfLottosPurchased) {
        System.out.println();
        System.out.println(countOfLottosPurchased + PUBLISH_LOTTOS_ANNOUNCEMENT);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static String getWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_ANNOUNCEMENT);
        String numbersRaw = Console.readLine();
//        checkInputWinningNumbers(numbersRaw);
        return numbersRaw;
    }

    public static String getBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_ANNOUNCEMENT);
        String bonusNumberRaw = Console.readLine();
//        checkInputBonusNumber(bonusNumberRaw);
        return bonusNumberRaw;
    }

    public static void printResult(Map<WinningResult, Integer> results) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_ANNOUNCEMENT);
        for(WinningResult result: results.keySet()) {
            if(result == WinningResult.RANK_NONE) {
                continue;
            }
            System.out.println(result.getAnnouncement() + " - " + results.get(result) + "개");
        }
    }

    public static void printYield(String yield) {
        System.out.println(String.format(YIELD_FORMAT_ANNOUNCEMENT, yield));
    }

    private static void checkInputMoney(String inputMoneyRaw) {
        boolean isMatch = Pattern.matches(INPUT_MONEY_PATTERN, inputMoneyRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] 1000의 배수를 입력하세요. 단, 1000000000 미만의 수만 입력해주세요. (ex: 2000, 12345000)"
        );
    }
}
