package lotto;

public class Application {
    public static void main(String[] args) {
        LotteryController controller = new LotteryController();

        try {
            controller.purchase();
            controller.setWinningNumber();
            controller.setBonusNumber();
            controller.figureStatistics();
        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
