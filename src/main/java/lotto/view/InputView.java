package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final static String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final static String REQUEST_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private final static String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int readPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        String purchasePrice = Console.readLine();
        InputException.validateIsNumber(purchasePrice);
        printNewLine();

        return Integer.parseInt(purchasePrice);
    }

    private void printNewLine() {
        System.out.println();
    }

    public List<Integer> readWinningLotto() {
        System.out.println(REQUEST_WINNING_LOTTO);
        List<Integer> winningLotto = new ArrayList<>();

        for (String lottoNumber : Console.readLine().split(",")) {
            winningLotto.add(InputException.validateIsNumber(lottoNumber));
        }
        printNewLine();

        return winningLotto;
    }

    public int readBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String bonusNumberInput = Console.readLine();
        printNewLine();

        return InputException.validateIsNumber(bonusNumberInput);
    }
}
