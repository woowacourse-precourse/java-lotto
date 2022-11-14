package lotto;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        player.purchaseLotto();
        player.getLottoNumbers();
        player.checkGetLottoNumbers();

        player.makeGenerate();
        player.calculateResult();
        player.showResult();
    }
}
