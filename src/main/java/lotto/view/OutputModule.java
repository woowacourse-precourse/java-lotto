package lotto.view;
import static lotto.view.PrintMessage.*;
public class OutputModule {
    public static void printInputPurchasePrice() {
        System.out.println(Guide_InputPurchasePrice.getMessage());
    }

    public static void printInputLuckyNumbers() {
        System.out.println(Guide_InputLuckyNumbers.getMessage());
    }

    public static void printInputBonusNumber() {
        System.out.println(Guide_InputBonusNumber.getMessage());
    }
}