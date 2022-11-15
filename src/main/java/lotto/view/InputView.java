package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.GuideMessage;

import static lotto.constants.GuideMessage.*;

public class InputView {

    public static String priceInput() {
        System.out.println(ENTER_PRICE);
        String userMoney = Console.readLine();

        return userMoney;
    }

    public static String lottoInput() {
        System.out.println(ENTER_TARGET);
        String targetInput = Console.readLine();

        return targetInput;
    }

    public static String bonusInput() {
        System.out.println(ENTER_BONUS);
        String bonusInput = Console.readLine();

        return bonusInput;
    }
}
