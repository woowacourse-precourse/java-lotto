package lotto;

import lotto.controller.LottoController;

import java.io.IOException;

import static lotto.view.OutputLotto.check;

public class Application {
    public static void main(String[] args){
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        }catch (IllegalArgumentException ignored){

        }
    }
}
