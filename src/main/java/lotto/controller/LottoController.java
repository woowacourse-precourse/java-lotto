package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private TicketMachine ticketMachine = new TicketMachine();
    private LottoMaker lottoMaker = new LottoMaker();

    public void process() {
        int ticket = getTicketFromUserByConsole();
        List<Lotto> lottos = getRandomLottoBy(ticket);
        WinningLotto winningLotto = getWinningLottoByUser();
        printLottoResult(lottos, winningLotto);
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

    private WinningLotto getWinningLottoByUser() {
        Lotto manualLotto = getManualLottoFromUserByConsole();
        int bonusNumber = getBonusNumberFromUserByConsole();
        return new WinningLotto(manualLotto, bonusNumber);
    }

    private void printLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRanking, Integer> lottoResult = LottoReader.getLottoResults(lottos, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }

    private Lotto getManualLottoFromUserByConsole() {
        List<Integer> lottoNumbers = InputView.getManualLottoNumberFromUser();
        return lottoMaker.getManualLotto(lottoNumbers);
    }

    private int getBonusNumberFromUserByConsole() {
        return InputView.getBonusNumberFromUser();
    }


}
