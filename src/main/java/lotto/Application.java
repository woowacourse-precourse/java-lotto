package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            LottoController lottoController = new LottoController();
            Money money = lottoController.purchase();
            List<Lotto> lottos = lottoController.generateLottos(money);
            WinningNumbers winningNumbers = lottoController.generateWinningNumbers();
            lottoController.showStatistics(winningNumbers, lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
