package lotto;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        try {
            Controller controller = new Controller();
            controller.run();
        } catch (IllegalArgumentException ie) {
            return;
        }
        
    }
}
