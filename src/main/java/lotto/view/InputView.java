package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static String PURCHASE_MONEY_MESSAGE="구입금액을 입력해 주세요.";
    private static String INPUT_NUMBERS_MESSAGE="당첨 번호를 입력해 주세요.";
    private static String COMMA=",";
    private static String INPUT_BONUS_MESSAGE="\n보너스 번호를 입력해주세요.";
    public static Integer requestPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_MESSAGE);
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> requestLottoNumbers() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
        String tmpInputNumbers = Console.readLine();
        List<Integer> inputNumbers = new ArrayList<>();
        String[] tmpInputNumber = tmpInputNumbers.split(COMMA);
        for (int i = 0; i < tmpInputNumber.length; i++) {
            inputNumbers.add(Integer.parseInt(tmpInputNumber[i]));
        }
        return inputNumbers;
    }

    public static int requestBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String inputBonusNumber = Console.readLine();
        return Integer.parseInt(inputBonusNumber);
    }
}
