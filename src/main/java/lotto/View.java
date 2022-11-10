package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Rank.Grade;

public class View {

    public static int inputMoney() {
        System.out.println(Messages.OUTPUT_START_GAME_MESSAGE);
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf(Messages.OUTPUT_BUY_MESSAGE, lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public static void printResult(Map<Integer, Integer> result) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(Messages.OUTPUT_WINNING_MESSAGE);
        for (Grade grade : Grade.values()) {
            if (grade.isCheck()) {
                System.out.printf(Messages.OUTPUT_BONUS_MESSAGE, grade.getMatchCount(), decimalFormat.format(grade.getPrize()),
                        result.get(7));
            }
            if (!grade.isCheck()) {
                System.out.printf(Messages.OUTPUT_RESULT_MESSAGE, grade.getMatchCount(), decimalFormat.format(grade.getPrize()),
                        result.get(grade.getMatchCount()));
            }
        }
    }

    public static void printYield(double yield) {
        System.out.printf(Messages.OUTPUT_YIELD_MESSAGE, yield);
    }
}
