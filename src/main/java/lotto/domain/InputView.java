package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int inputMoney;
    public static List<Integer> winningNumbers = new ArrayList<>();

    public static void inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoneyString = Console.readLine();
        Validation.validateInputMoney(inputMoneyString);
        inputMoney = Integer.parseInt(inputMoneyString);
    }


    public static void showNumberOfLottos(int money, int lottoPrice) {
        System.out.println(money / lottoPrice + "개를 구매했습니다.");
    }

    public static void inputWinningNumbers() {
        showWinningNumbersInputMessage();
        String[] inputWinningNumbers = Console.readLine().split(",");
        Validation.validateWinningNumbers(inputWinningNumbers);
        for (String winningNumber : inputWinningNumbers) {
            winningNumbers.add(Integer.valueOf(winningNumber));
        }
    }

    private static void showWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
