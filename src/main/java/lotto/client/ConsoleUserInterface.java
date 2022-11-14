package lotto.client;

import camp.nextstep.edu.missionutils.Console;
import lotto.InvalidInputMessage;
import lotto.Lotto;

public class ConsoleUserInterface {

    private final static String MSG_REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public ConsoleUserInterface() {
    }

    protected void output(String message) {
        System.out.println(message);
    }

    protected String input() {
        String inputLine;
        try {
            inputLine = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_EMPTY_INPUT
            );
        }
        return inputLine;
    }

    public int requestPurchaseAmount() {
        output(MSG_REQUEST_PURCHASE_AMOUNT);
        String input = input();
        validatePurchasingAmount(input);
        return Integer.parseInt(input);
    }

    private void validateAs_JavaInteger(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_NOT_JAVA_INTEGER
            );
        }
    }

    private void validatePurchasingAmount(String input) {
        validateAs_JavaInteger(input);
        if (Integer.parseInt(input) % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_MONEY_UNIT
            );
        }
    }
}
