package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class Controller {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_LOTTO = "구입금액을 입력해 주세요.";
    private static final String NOT_NUMBER = "숫자가 아닙니다.";

    public void start() {
        String amount;
        amount = readLine();

    }

    public void isValidatePurchase(String userInput) {

    }

    public void isValidateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER);
        }
    }
}
