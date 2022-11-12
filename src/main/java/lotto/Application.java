package lotto;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Controller controller = new Controller();
        double money = console.inputMoney();
        controller.getCount(money);
        // 금액 100
    }
}
