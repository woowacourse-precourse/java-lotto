package lotto.controller;

import lotto.domain.NumberOfLottos;
import lotto.view.InputView;

public class LottoController {

    public void gameStart() {
        try {
            NumberOfLottos numberOfLottos = getPriceAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private NumberOfLottos getPriceAmount() {
        return new NumberOfLottos(InputView.getPriceAmount());
    }
}
