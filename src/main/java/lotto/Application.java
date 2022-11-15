package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.startLotto();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}