package lotto;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.start();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }
}
