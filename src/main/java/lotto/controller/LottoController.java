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

            getLottoTickets();

            List<String> winningNumbers = InputView.writeWinningNumbers();
            int bonusNumber = InputView.writeBonusNumber();

            getWinningResult(winningNumbers, bonusNumber);
            getProfit();
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + e);
        }
    }

    private void getLottoTickets(){
        for (int i=0; i<lottoCalculator.getTicketSize(); i++){
            lottos.add(new Lotto(NumberGenerator.GenerateNumbers()));
        }

        OutputView.writeLottoTickets(lottos);
    }

    private void getWinningResult(List<String> winningNumbers, int bonusNumber){
        for (Lotto lotto : lottos){
            int rank = lotto.checkRanking(winningNumbers, bonusNumber);
            winningResult.set(rank, winningResult.get(rank)+1);
        }

        OutputView.writeWinningResult(winningResult);
    }

    private void getProfit(){
        double profit = lottoCalculator.getProfit(winningResult);

        OutputView.writeProfit(profit);
    }
}
