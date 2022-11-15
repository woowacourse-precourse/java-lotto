package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            GameManager gameManager = new GameManager();
            gameManager.run();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
