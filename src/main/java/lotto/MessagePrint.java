package lotto;

import java.util.HashMap;
import java.util.List;

public class MessagePrint {

    public static void printInputAmount() {
        System.out.println(Message.START.getMessage());
    }

    public static void printLottoCount(int numberOfLotto) {
        System.out.printf("%d" + Message.BUY.getMessage() + "\n", numberOfLotto);
    }


    public static void printInputWinningNumber() {
        System.out.println(Message.INPUT.getMessage());
    }

    public static void printBonusNumber() {
        System.out.println(Message.BONUS.getMessage());
    }



}
