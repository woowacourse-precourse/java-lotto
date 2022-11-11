package lotto.domain.view;

import static lotto.domain.view.IOMessage.INPUT_DESIGNATE_BONUS;
import static lotto.domain.view.IOMessage.INPUT_DESIGNATE_FIRSTPLCAE;
import static lotto.domain.view.IOMessage.INPUT_PURCHASE_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputData {
    public static String purchaseLotto(){
        System.out.println(INPUT_PURCHASE_LOTTO.getMessage());
        return Console.readLine();
    }

    public static String designateFirstPlace(){
        System.out.println(INPUT_DESIGNATE_FIRSTPLCAE.getMessage());
        return Console.readLine();
    }

    public static String designateBonus(){
        System.out.println();
        System.out.println(INPUT_DESIGNATE_BONUS.getMessage());
        return Console.readLine();
    }
}
