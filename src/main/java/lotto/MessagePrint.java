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

    public static void printUserLotto(List<Integer>[] userLotto, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(userLotto[i]);
        }
    }


    public static void printInputWinningNumber() {
        System.out.println(Message.INPUT.getMessage());
    }

    public static void printBonusNumber() {
        System.out.println(Message.BONUS.getMessage());
    }

    public static void printSTATISTICS() {
        System.out.println(Message.STATISTICS.getMessage());
    }
    public static void printCheckLotto(HashMap<Integer, Integer> lottoCheck) {
        System.out.printf(Message.THREE.getMessage() + "%d개\n", lottoCheck.get(3));
        System.out.printf(Message.FOUR.getMessage() + "%d개\n", lottoCheck.get(4));
        System.out.printf(Message.FIVE.getMessage() + "%d개\n", lottoCheck.get(5));
        System.out.printf(Message.FIVE_BONUS.getMessage() + "%d개\n", lottoCheck.get(7));
        System.out.printf(Message.SIX.getMessage() + "%d개\n", lottoCheck.get(6));
    }

}
