package lotto;

public class Application {
    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }

    public static void play(){
        InputController game = new InputController();
        int count = game.checkTicketCount();

    }
}
