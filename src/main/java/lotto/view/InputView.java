package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
현
import static lotto.view.OutputView.printPriceInputMessage;

public class InputView {
    public static int lottoPurchaseMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;
    private static final String COMMA = ",";

    public static int inputLottoPurchaseMoney() {
        printPriceInputMessage();
        lottoPurchaseMoney = Integer.parseInt(Console.readLine());
        return lottoPurchaseMoney;
    }

    public static List<Integer> inputWinningNumber() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String value : inputNumbers.split(COMMA)) {
            winningNumbers.add(Integer.parseInt(value));
        }
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
