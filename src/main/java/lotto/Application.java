package lotto;

public class Application {

    public static void main(String[] args) {
        try {
            Play play = new Play();
            play.start();
        } catch (IllegalArgumentException e) {
        }
    }
}
