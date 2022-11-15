package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoMachine.LotteryTicketsIssuance;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

            LottoController controller = new LottoController();
            controller.run();
    }
}
