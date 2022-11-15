
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame game = new LottoGame();
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}