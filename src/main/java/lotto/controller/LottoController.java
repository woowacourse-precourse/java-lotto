package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private TicketMachine ticketMachine = new TicketMachine();
    private LottoMaker lottoMaker = new LottoMaker();
    private ProfitCalculator profitCalculator = new ProfitCalculator();

    public void process() {
        try {
            int ticket = getTicketFromUserByConsole();
            List<Lotto> lottos = getRandomLottoBy(ticket);
            WinningLotto winningLotto = getWinningLottoFromUserByConsole();
            printLottoResultByConsole(lottos, winningLotto);
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error.getMessage());
        }
    }

    private int getTicketFromUserByConsole() {
        int money = InputView.getMoneyFromUser();
        int ticket = ticketMachine.getTicket(money);
        OutputView.printNumberOfIssuedLotto(ticket);
        return ticket;
    }

    private List<Lotto> getRandomLottoBy(int ticket) {
        List<Lotto> lottos = lottoMaker.getRandomLottos(ticket);
        OutputView.printLottosInformation(lottos);
        return lottos;
    }

    private WinningLotto getWinningLottoFromUserByConsole() {
        Lotto manualLotto = getManualLottoFromUserByConsole();
        int bonusNumber = getBonusNumberFromUserByConsole();
        return new WinningLotto(manualLotto, bonusNumber);
    }

    private Lotto getManualLottoFromUserByConsole() {
        List<Integer> lottoNumbers = InputView.getManualLottoNumberFromUser();
        return lottoMaker.getManualLotto(lottoNumbers);
    }

    private int getBonusNumberFromUserByConsole() {
        LottoNumber lottoNumber = new LottoNumber(InputView.getBonusNumberFromUser());
        return lottoNumber.getValue();
    }

    private void printLottoResultByConsole(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRanking, Integer> lottoResultData = LottoReader.getLottoRankings(lottos, winningLotto);
        OutputView.printLottoResult(lottoResultData);
        printLottoRate(profitCalculator.getLottoYield(lottoResultData));
    }

    private void printLottoRate(double returnRate) {
        OutputView.printReturnRate(returnRate);
    }

}
