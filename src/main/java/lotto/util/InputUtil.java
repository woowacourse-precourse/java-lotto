package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.PrintView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.CheckUtil.*;

public class InputUtil {
    private PrintView printView = new PrintView();

    public int inputPurchasePrice() {
        printView.printInputPurchasePrice();
        String input = Console.readLine();
        try {
            int inputPrice = checkIsString(input);
            checkIsDivedByTHOUSAND(inputPrice);
            return inputPrice;
        } catch (IllegalArgumentException e) {
            printView.printErrorMessage(e);
            return inputPurchasePrice();
        }
    }

    public List<Integer> inputWinningNumber() {
        printView.printInputWinningNumber();
        String input = Console.readLine();
        try {
            List<Integer> winning = stringArrToIntList(commaSeparation(input));
            checkIsValidWinningNumber(winning);
            return winning;
        } catch (IllegalArgumentException e) {
            printView.printErrorMessage(e);
            return inputWinningNumber();
        }
    }

    public int inputBonusNumber() {
        printView.printInputBonusNumber();
        String input = Console.readLine();
        try {
            int bonus = Integer.valueOf(input);
            checkIsValidBonusNumber(bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            printView.printErrorMessage(e);
            return inputBonusNumber();
        }
    }

    private String[] commaSeparation(String str) {
        String[] arr = str.split(",");
        return arr;
    }

    private List<Integer> stringArrToIntList(String[] input) {
        List<Integer> winning = new ArrayList<>();
        for (String s : input) {
            winning.add(Integer.valueOf(s));
        }
        return winning;
    }
}
