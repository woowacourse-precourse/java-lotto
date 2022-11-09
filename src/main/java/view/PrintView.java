package view;

import util.message.ConsoleMessage;
import util.message.ErrorMessage;

public class PrintView {

    public static void purchaseMoney() {
        System.out.println(ConsoleMessage.MESSAGE_PURCHASE_MONEY);
    }

    public static void error(String message){
        System.out.println(ErrorMessage.PREFIX_ERROR + message);
    }
}
