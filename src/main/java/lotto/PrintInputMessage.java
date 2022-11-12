package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;

public class PrintInputMessage {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";

    private PrintInputMessage() {
    }

    private static int getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    private static List<String> getWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER);
        String inputTmpNum = Console.readLine();
        return Arrays.asList(inputTmpNum.split(","));
    }

    private static String getBonusLottoNumber() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }

}
