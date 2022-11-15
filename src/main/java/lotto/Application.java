package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGame game = new LottoGame();
            game.run();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
