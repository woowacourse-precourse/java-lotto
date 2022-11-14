package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
