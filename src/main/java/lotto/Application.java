package lotto;

import lotto.controller.LottoGame;
import lotto.domain.UserLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try{
            LottoGame lottoGame = new LottoGame();
            lottoGame.startLotto();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
