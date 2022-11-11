package lotto.presentation.view;

import constants.LottoGameMessage;

public class LottoGamePrinter {

    public static void printEnterLottoAmount() {
        System.out.println(LottoGameMessage.READ_LOTTO_COUNT);
    }

    public static void printEnterWinNumber() {
        System.out.println(LottoGameMessage.READ_WIN_NUMBER);
    }

    public static void printEnterBonusNumber() {
        System.out.println(LottoGameMessage.READ_BONUS_NUMBER);
    }

}
