package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Application game = new Application();
            game.playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void playLotto() {

    }
}
