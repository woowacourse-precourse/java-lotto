package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import util.message.ErrorMessage;


public class ReceiveView {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static int purchaseLotto() {
        String money = Console.readLine();
        purchaseLottoValid(money);
        return Integer.parseInt(money);
    }

    public static void purchaseLottoValid(String money){
        if (!isDigit(money)) {
            PrintView.error(ErrorMessage.NOT_STRING_MONEY);
            throw new IllegalArgumentException(ErrorMessage.NOT_STRING_MONEY);
        }
    }

    private static boolean isDigit(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            return false;
        }
        return true;
    }



}
