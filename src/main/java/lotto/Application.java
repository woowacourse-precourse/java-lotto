package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();

        game.buyLotto();
        game.drawLotto();
        game.func();
        System.out.println(game.compareResult);

        System.out.println(game.myLottoNumbers);
    }
}
