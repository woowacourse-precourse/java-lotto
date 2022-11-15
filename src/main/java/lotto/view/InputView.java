package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_MONEY_COMMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUM_COMMENT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUM_COMMENT = "보너스 번호를 입력해 주세요.";

    private InputView(){
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_COMMENT);
        return stringToInt(Console.readLine());
    }

    public static List<Integer> inputLottoNum() {
        System.out.println(INPUT_LOTTO_NUM_COMMENT);
        return stringToList(Console.readLine());
    }

    public static int inputBonusNum() {
        System.out.println(INPUT_BONUS_LOTTO_NUM_COMMENT);
        return stringToInt(Console.readLine());
    }

    public static List<Integer> stringToList(String input) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String num : input.split(",")) {
            winNumbers.add(stringToInt(num));
        }
        return winNumbers;
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

}
