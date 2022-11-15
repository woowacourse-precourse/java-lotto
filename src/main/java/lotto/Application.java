package lotto;

import static lotto.util.PrintService.printErrorMessage;

import lotto.controller.LottoController;
import lotto.repository.RankCountRepository;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningStatisticService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputService inputService = new InputService();
            LottoService lottoService = new LottoService();
            RankCountRepository rankCountRepository = new RankCountRepository();
            WinningStatisticService winningStatisticService =
                new WinningStatisticService(rankCountRepository);
            LottoController lottoController =
                new LottoController(winningStatisticService, inputService, lottoService);
            lottoController.play();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
