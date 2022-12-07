package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;

import static lotto.util.message.OutputMessage.INPUT_PURCHASE_AMOUNT;

public class InputView {
    public static int purchaseMoney(){
        System.out.println(INPUT_PURCHASE_AMOUNT.get());
        String purchaseMoney = Console.readLine();
        return numberCheck(purchaseMoney);
    }

    public static int numberCheck(String number){
        return InputValidator.validate(number);
    }
}
