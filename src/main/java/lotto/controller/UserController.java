package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Number;
import lotto.exception.BonusNumber;
import lotto.exception.PurchaseAmount;
import lotto.exception.WinNumber;
import lotto.view.Input;
import lotto.view.Output;

public class UserController {
    public static int getPurchaseAmount() {
        Output.printStartMsg();
        String input = Input.inputPurchaseAmount();
        PurchaseAmount.exceptionPurchaseAmount(input);
        int purchaseAmount = toStringPurchaseAmount(input);

        return purchaseAmount;
    }

    public static int toStringPurchaseAmount(String input) {
        int purchaseAmount = Integer.valueOf(input);
        return purchaseAmount;
    }

    public static int getPurchaseNumber(int purchaseAmount) {
        int purchaseNumber = purchaseAmount / Number.PRICE.getNumber();
        return purchaseNumber;
    }

    public static List<Integer> getWinNumber() {
        Output.printWinningMsg();
        String input = Input.inputWinNumber();
        WinNumber.exceptionWinNumber(input);
        List<Integer> winNumber = toListWinNumber(input);
        WinNumber.exceptionDuplication(winNumber);
        return winNumber;
    }

    public static int getBonusNumber(List<Integer> winNumber) {
        Output.printBonusMsg();
        String input = Input.inputBonusNumber();
        BonusNumber.exceptionBonusNumber(input, winNumber);
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

    public static List<Integer> toListWinNumber(String input) {
        List<Integer> winNumber = new ArrayList<>();
        String[] arr = input.split(",");
        for (int i = 0; i < arr.length; i++) {
            winNumber.add(Integer.valueOf(arr[i]));
        }
        return winNumber;
    }
}