package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Game.run();
        } catch (IllegalArgumentException E) {
            System.out.println(E.getMessage());
        }
    }
}
