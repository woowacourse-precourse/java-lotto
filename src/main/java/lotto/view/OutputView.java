package lotto.view;

import lotto.enums.StringEnum;

import static lotto.enums.StringEnum.WIN_NUMBER;

public class OutputView {
    public static void askWinNumberPrint() {
        System.out.println(WIN_NUMBER.getMessage());
    }

    public static void askBonusNumberPrint() {
        System.out.println(StringEnum.BONUS_NUMBER.getMessage());
    }

    public static void printObjectState(String print){
        System.out.println(print);
    }

}
