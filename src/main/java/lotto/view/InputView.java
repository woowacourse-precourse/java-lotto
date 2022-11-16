package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.enums.GameMessage;

public class InputView {
    public static String getPrice() {
        System.out.println(GameMessage.PRICE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getLuckySix() {
        System.out.println(GameMessage.SIX_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getLuckyBonus() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

}
