package lotto;

import lotto.adapter.in.InputController;
import lotto.adapter.in.LottoController;
import lotto.view.BuyLottoView;
import lotto.view.ResultView;

import javax.swing.text.View;

public class Application {

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.play();
    }
}
