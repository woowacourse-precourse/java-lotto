package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.model.AutoLottoGenerator;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        try {
            lottoController.play();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
