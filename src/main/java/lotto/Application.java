package lotto;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        try{
            gameManager.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
