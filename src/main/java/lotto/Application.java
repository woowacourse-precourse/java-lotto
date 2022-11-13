package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();

            controller.inputUserMoney();
            controller.purchaseLotto();
            controller.inputWinningNumber();
            controller.inputBonusNumber();
            controller.printStatistics();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
