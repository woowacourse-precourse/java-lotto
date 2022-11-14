package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args){
        LottoGame lottoGame=new LottoGame();
        try {
            lottoGame.startGame();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
