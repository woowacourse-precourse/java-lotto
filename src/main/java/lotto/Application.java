package lotto;

import static lotto.utils.Constant.*;

import lotto.controller.LottoController;
import lotto.utils.Constant;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController buyLotto = new LottoController();
        try {
            buyLotto.run();
        } catch (IllegalArgumentException e) {
            System.out.println(END_ERROR);
        }
    }
}
