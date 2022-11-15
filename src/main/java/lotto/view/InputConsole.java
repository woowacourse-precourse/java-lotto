package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.ConsoleMessage.*;

public class InputConsole {
    public InputConsole() {

    }

    public static String readLine() {
        return Console.readLine().strip();
    }

    public static int askPurchasePrice() {
        System.out.println(TYPE_PURCHASE_PRICE);
        String input = readLine();
        Validator.isInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> askPrizeLottoNumber() {
        System.out.println(TYPE_PRIZE_LOTTO_NUMBER);
        String input = readLine();
        Validator.isValidPrizeNumbers(input);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int askBonusNumber() {
        System.out.println(TYPE_BONUS_NUMBER);
        String input = readLine();
        Validator.isInteger(input);
        return Integer.parseInt(input);
    }
}
