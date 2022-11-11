package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL = "\n보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public String inputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        return money;
    }

    public List<String> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        String[] numbers = input.split(SEPARATOR);
        return Arrays.asList(numbers);
    }

    public String inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        String input = Console.readLine();
        return input;
    }
}
