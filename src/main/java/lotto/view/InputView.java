package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static String purchaseMoney;
    private static String winningNumbers;
    private static String bonusNumber;

    public static String enterPurchaseMoney() {
        OutputView.printEnterPurchaseAmount();
        purchaseMoney = Console.readLine();
        return purchaseMoney;
    }


    public static List<Integer> enterWinningNumbers() {
        OutputView.printEnterWinningNumbers();
        winningNumbers = Console.readLine();
        return changeTypeForSystem(winningNumbers);
    }

    public static int enterBonusNumber() {
        OutputView.printEnterBonusNumber();
        bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    private static List<Integer> changeTypeForSystem(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","))
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}


