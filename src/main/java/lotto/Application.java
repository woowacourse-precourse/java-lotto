package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();

            controller.inputUserMoney();
            controller.purchaseLotto();
            controller.inputWinningNumber();
            controller.inputBonusNumber();
            controller.printStatistics();
            controller.printReturnRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
