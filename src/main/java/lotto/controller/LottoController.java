package lotto.controller;

import lotto.service.LottoGameMachineService;
import lotto.service.LottoGameMachineServiceImpl;
import lotto.view.Input;
import lotto.view.Output;


public class LottoController {
    private final Input input;
    private final Output output;

    private final static LottoGameMachineService service = new LottoGameMachineServiceImpl();

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start(){

        service.enterMoney(input.getMoney());

        output.printNumberOfLotto(service.readLottoQuantity());

        output.printLottoNumbers(service.readLottoNumbers());

        service.enterTheWinningNumbers(input.getWinningNumbers());

        service.enterBonusNumber(input.getBonusNumber(service.readWinningNumbers()));

        output.printStatisticsMessage();

        output.printStatistics(service.calculateStatistics(), service.readMoney());
    }

}
