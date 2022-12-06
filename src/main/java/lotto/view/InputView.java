package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.message.OutputMessage.INPUT_BONUS_NUMBER;
import static lotto.util.message.OutputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.util.message.OutputMessage.INPUT_WINNING_LOTTO;

public class InputView {

    public static int readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.get());
        String purchaseAmount = Console.readLine();
        return InputValidator.validate(purchaseAmount);
    }

    public static List<Integer> readWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO.get());
        String[] input = Console.readLine().split(",");
        List<Integer> winningLotto = new ArrayList<>();
        int number;
        for (String s : input) {
            number = InputValidator.validate(s);
            winningLotto.add(number);
        }
        return winningLotto;
    }

    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.get());
        return InputValidator.validate(Console.readLine());
    }
}
