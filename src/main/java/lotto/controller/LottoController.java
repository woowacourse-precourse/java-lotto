package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoWinningNumber;
import lotto.service.LottoMachineService;
import lotto.service.LottoStatisticsService;
import lotto.service.LottoWinningNumberService;

public class LottoController {
    private final LottoMachineService lottoMachineService = new LottoMachineService();
    private final LottoWinningNumberService lottoWinningNumberService = new LottoWinningNumberService();
    private LottoStatisticsService lottoStatisticsService;

    public void run() {
        init();
        lottoStatisticsService.getResult(lottoMachineService.getMoney());
    }

    private void init() {
        LottoMachine lottoMachine = lottoMachineService.setLottoMachine();
        lottoMachineService.print();

        LottoWinningNumber lottoWinningNumber = lottoWinningNumberService.setLottoWinningNumber();
        lottoStatisticsService = new LottoStatisticsService(lottoMachine, lottoWinningNumber);
    }
}
