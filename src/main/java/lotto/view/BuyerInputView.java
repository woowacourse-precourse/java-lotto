package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.enums.GameMessage;

public class BuyerInputView {
    public static String getInputPrice() {
        System.out.println(GameMessage.PROMPT_MESSAGE.getGameMessage());
        String inputNum = Console.readLine();
        return inputNum;
    }

    public static String getPickNum() {
        System.out.println(GameMessage.PICK_MESSAGE.getGameMessage());
        String inputNum = Console.readLine();
        return inputNum;
    }

    public static String getBonusNum() {
        System.out.println(GameMessage.PICK_BONUS_MESSAGE.getGameMessage());
        String inputNum = Console.readLine();
        return inputNum;
    }


}
