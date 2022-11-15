package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoGame {
    String purchaseAmount;
    Input input = new Input();
    Output output = new Output();

    public void start() {
        try {
            LottoCount lottoCount = new LottoCount(input.lottoPurchaseAmount());
            List<Lotto> lottoPapers = buyLotto(lottoCount.getLottoCount());
            ProvidNumber providNumber = new ProvidNumber(input.lottoWinningNumbers(), input.lottoBonusNumber());
            calculateResult(lottoPapers, providNumber, lottoCount.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> buyLotto(int count) {
        LottoMake lottoMake = new LottoMake(count);
        List<Lotto> lottoPapers = lottoMake.getLottoPapers();

        output.printLottoPaperCount(count);
        for (int i = 0; i < lottoPapers.size(); i++) {
            output.printLottoPapers(lottoPapers.get(i).getNumbers());
        }
        return lottoPapers;
    }

    private void calculateResult(List<Lotto> lottoPapers, ProvidNumber providNumber, int purchseAmount) {
        RankCalculator rankCalculator = new RankCalculator(lottoPapers, providNumber);
    }
}
