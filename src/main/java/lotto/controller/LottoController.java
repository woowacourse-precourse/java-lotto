package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Money money;

    private Winner winner;

    public void start() {
        try {
            int lottoTicketCount = buyLottoTicket();
            List<Lotto> lottos = createLotto(lottoTicketCount);
            showLotto(lottoTicketCount, lottos);
            Map<LottoRank, Integer> lottoResult = makeLottoResult(lottos, enterLotto(), enterBonus());
            String profit = calculateProfit(lottoTicketCount, lottoResult);
            showLottoResult(lottoResult, profit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int buyLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        String moneyInput = inputView.enterMoneyInput();
        money = new Money(moneyInput);
        return lottoTicket.countLotto(moneyInput);
    }

    public List<Lotto> createLotto(int lottoTicket) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.createLottoNumbers(lottoTicket);
    }

    public void showLotto(int lottoCount, List<Lotto> lottos) {
        outputView.printLottoAmount(lottoCount);
        outputView.printLottoNumbers(lottos);
    }

    public List<Integer> enterLotto() {
        String lottoWinningNumber = inputView.enterLottoNumber();
        winner = new Winner(lottoWinningNumber);
        return winner.getWinningNumber();
    }

    public int enterBonus() {
        String lottoBonus = inputView.enterBonusNumber();
        Bonus bonus = new Bonus(lottoBonus);
        return bonus.getBonusNumber();
    }

    public Map<LottoRank, Integer> makeLottoResult(List<Lotto> lottoNumbers, List<Integer> winnerNumber, int bonusNum) {
        Referee referee = new Referee();
        referee.createLottoResult(lottoNumbers, winnerNumber, bonusNum);
        return referee.getLottoResultCount();
    }

    public String calculateProfit(int lottoCount, Map<LottoRank, Integer> lottoResultCount) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculate(lottoCount, lottoResultCount);
    }

    public void showLottoResult(Map<LottoRank, Integer> lottoResultCount, String profit) {
        outputView.printLottoResult(lottoResultCount);
        outputView.printProfit(profit);
    }

}
