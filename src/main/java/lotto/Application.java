package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        try {
            game.run();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
