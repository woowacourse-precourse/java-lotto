package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Player player = new Player();
            player.purchaseLotto();
            player.getLottoNumbers();
            player.checkGetLottoNumbers();
            player.makeGenerate();
            player.calculateResult();
            player.showResult();
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
