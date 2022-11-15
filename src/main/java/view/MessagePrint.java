package view;

import java.util.HashMap;
import java.util.List;

public class MessagePrint {

    public static void printInputAmount() {
        System.out.println(Message.PURCHASE_AMOUNT.getMessage());
    }

    public static void printLottoCount(int numberOfLotto) {
        System.out.printf("%d" + Message.BUY.getMessage() + "\n", numberOfLotto);
    }

    public static void printUserLottoNumber(List<Integer>[] userLotto, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(userLotto[i]);
        }
    }


    public static void printInputWinningNumber() {
        System.out.println(Message.WINNING_NUMBER.getMessage());
    }

    public static void printInputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER.getMessage());
    }

    public static void printStatistics() {
        System.out.println(Message.STATISTICS.getMessage());
    }

    public static void printWinningStatistics(HashMap<Integer, Integer> lottoCheck) {
        System.out.printf(Message.THREE.getMessage() + "%d개\n", lottoCheck.get(3));
        System.out.printf(Message.FOUR.getMessage() + "%d개\n", lottoCheck.get(4));
        System.out.printf(Message.FIVE.getMessage() + "%d개\n", lottoCheck.get(5));
        System.out.printf(Message.FIVE_BONUS.getMessage() + "%d개\n", lottoCheck.get(7));
        System.out.printf(Message.SIX.getMessage() + "%d개\n", lottoCheck.get(6));
    }

    public static void printYield(double yield) {
        System.out.printf(Message.YIELD.getMessage() + "%.1f%%입니다.", yield);
    }

}
