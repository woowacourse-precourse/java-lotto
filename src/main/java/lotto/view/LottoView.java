package lotto.view;

import static lotto.LottoConstant.GAME_START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    private LottoView() {
    }

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static String getLottoPurchaseAmount() {
        return Console.readLine();
    }
}
