package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            GameManager gameManager = new GameManager();
            gameManager.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
