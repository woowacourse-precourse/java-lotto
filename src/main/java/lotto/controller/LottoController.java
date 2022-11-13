package lotto.controller;

import lotto.exception.LottoException;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final LottoException lottoException = new LottoException();

    private Winner winner;

    public void start(){


    }

    public int buyLottoTicket(){
        LottoTicket lottoTicket = new LottoTicket();
        String moneyInput = inputView.enterMoneyInput();
        lottoException.checkMoneyInput(moneyInput);
        return lottoTicket.countLotto(moneyInput);
    }

    public List<Lotto> createLotto(int lottoTicket){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.createLottoNumbers(lottoTicket);
    }

    public void showLotto(int lottoCount,List<Lotto> lottos){
        outputView.printLottoAmount(lottoCount);
        outputView.printLottoNumbers(lottos);
    }

    public List<Integer> enterLotto(){
        String lottoWinningNumber = inputView.enterLottoNumber();
        winner = new Winner(lottoWinningNumber);
        return winner.getLottoWinningNumber();
    }

    public int enterBonus(){
        String lottoBonus = inputView.enterBonusNumber();
        Bonus bonus = new Bonus(lottoBonus);
        return bonus.getBonusNumber();
    }

    public Map<LottoRank, Integer> makeLottoResult(List<Lotto> lottoNumbers, List<Integer> winnerNumber, int bonusNum){
        Referee referee = new Referee();
        referee.createLottoResult(lottoNumbers,winnerNumber,bonusNum);
        return referee.getLottoResultCount();
    }

    public String calculateProfit(int lottoCount, Map<LottoRank, Integer> lottoResultCount){
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculate(lottoCount,lottoResultCount);
    }

    public void showLottoResult(Map<LottoRank, Integer> lottoResultCount,String profit){
        outputView.printLottoResult(lottoResultCount);
        outputView.printProfit(profit);
    }

}
