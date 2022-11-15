package lotto.input_processing;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserInputException;

public class InputPrice {
    static UserInputException userInputException = new UserInputException();

    public InputPrice(){}

    /** 구입금액 입력받기 기능 */
    private static int inputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasingAmount = Console.readLine();
        if (!userInputException.checkInputIsInteger(purchasingAmount)){
            throw new IllegalArgumentException("[ERROR]");
        }
        return Integer.parseInt(purchasingAmount);
    }
}
