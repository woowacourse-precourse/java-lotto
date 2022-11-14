package lotto.View;

import lotto.Model.Lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static lotto.Model.Lotto.stringToInt;
import static lotto.Model.Lotto.stringToList;
import static lotto.Model.Money.checkUnit;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String MONEY_CHAR_ERROR_MESSAGE = " 숫자만 입력 가능합니다.";
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";

    public static int inputAmount() {
        System.out.println(MONEY_INPUT);
        int inputMoney = 0;
        try {
            inputMoney = parseInt(readLine());
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_MESSAGE+MONEY_CHAR_ERROR_MESSAGE);
        }
        return checkUnit(inputMoney);
    }

    public static void printWinningNumberInput() {
        System.out.println(WINNING_NUMBER_SENTENCE);
        new Lotto(stringToList(readLine()));
    }

    public static void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_SENTENCE);
        String temp = readLine();
        Lotto.setBonusNumber(stringToInt(temp));
    }

    public static int inputAmount(String input){
        System.out.println(MONEY_INPUT);
        int inputMoney;
        try {
            inputMoney = parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_MESSAGE+MONEY_CHAR_ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return checkUnit(inputMoney);
    }

}
