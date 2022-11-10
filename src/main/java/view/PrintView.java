package view;

import util.message.ConsoleMessage;
import util.message.ErrorMessage;

public class PrintView {

    public static void purchaseLotto() {
        System.out.println(ConsoleMessage.MESSAGE_PURCHASE_LOTTO);
    }

    public static void error(String message){
        System.out.println(ErrorMessage.PREFIX_ERROR + message);
    }
}
