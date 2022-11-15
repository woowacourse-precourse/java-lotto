package lotto;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Ui(), new LottoTicket());
        try {
            game.start();
        }catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
