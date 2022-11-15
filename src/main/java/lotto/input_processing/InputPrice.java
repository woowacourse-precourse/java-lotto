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
    /** 구입금액에 따른 로또 구매 개수 처리 기능 */
    private static int countingLottoCounts(int purchasingAmount) {
        if (!userInputException.checkMultipleOfThousand(purchasingAmount)){
            throw new IllegalArgumentException("[ERROR]");
        }
        // 구매한 로또 개수를 출력한다.
        System.out.println(purchasingAmount / 1000 + "개를 구매했습니다.");
        return purchasingAmount / 1000;
    }

}
