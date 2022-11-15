package lotto;

import lotto.controller.LottoController;
import lotto.domain.GameSet;

public class Application {
    public static void main(String[] args){
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        }catch (IllegalArgumentException e){
            return;
        }
    }
}
