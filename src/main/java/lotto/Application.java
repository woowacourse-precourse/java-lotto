package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame();

        try{
            lottoGame.start();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // TODO: 프로그램 구현

    }
}
