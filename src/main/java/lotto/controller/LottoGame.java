package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoMake;
import lotto.view.Input;

import java.util.List;

public class LottoGame {
    String purchaseAmount;
    Input input = new Input();

    public void start() {
        LottoCount lottoCount = new LottoCount(input.lottoPurchaseAmount());
        List<Lotto> lottoPapers = buyLotto(lottoCount.getLottoCount());

        input.lottoWinningNumbers();


        input.lottoBonusNumber();
    }

    private List<Lotto> buyLotto(int count) {
        LottoMake lottoMake = new LottoMake(count);
        List<Lotto> lottoPapers = lottoMake.getLottoPapers();

        return lottoPapers;
    }
}
