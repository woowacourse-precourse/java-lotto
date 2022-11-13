package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    LottoCalculator lottoCalculator;
    List<Lotto> lottos;
    List<Integer> winningResult;

    public LottoController(){
        lottos = new ArrayList<>();
        winningResult = Arrays.asList(0,0,0,0,0,0);
    }

    public void start(){
        try{
            int budget = InputView.writeBudget();
            lottoCalculator = new LottoCalculator(budget);

            for (int i=0; i<lottoCalculator.getTicketSize(); i++){
                Lotto newLotto = new Lotto(NumberGenerator.GenerateNumbers());
                lottos.add(newLotto);
            }

            OutputView.writeLottoTickets(lottos);

            List<String> winningNumbers = InputView.writeWinningNumbers();
            int bonusNumber = InputView.writeBonusNumber();

            for (Lotto lotto : lottos){
                int rank = lotto.checkRanking(winningNumbers, bonusNumber);
                winningResult.set(rank, winningResult.get(rank)+1);
            }

            OutputView.writeWinningResult(winningResult);

            double profit = lottoCalculator.getProfit(winningResult);

            OutputView.writeProfit(profit);
        }
        catch (IllegalArgumentException e){
            System.err.println("[ERROR]" + e);
        }
    }
}
