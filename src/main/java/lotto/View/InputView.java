package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Money;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Model.Lotto.stringToInt;
import static lotto.Model.Lotto.stringToList;

public class InputView {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";

    public static void inputAmount() {
        System.out.println(MONEY_INPUT);
        Money.setInputMoney(readLine());    }

    public static void printWinningNumberInput() {
        System.out.println(WINNING_NUMBER_SENTENCE);
        new Lotto(stringToList(readLine()));
    }

    public static void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_SENTENCE);
        String temp = readLine();
        Lotto.setBonusNumber(stringToInt(temp));
    }

}
