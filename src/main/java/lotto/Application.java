package lotto;

public class Application {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        try {
            gameRunner.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
