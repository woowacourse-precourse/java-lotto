package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoStore lottoStore;

    public LottoController(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void run() {
        try {
            LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();
            WinningNumbers winningNumbers = getWinningNumbers();
            List<Lotto> lottoTickets = lottoStore.buyLottoTickets(lottoPurchaseMoney.get());
            outputView.outputLottoTickets(lottoTickets);
            LottoResult lottoResult = makeLottoResult(winningNumbers, lottoTickets);


        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private LottoPurchaseMoney getLottoPurchaseMoney() {
        int lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();
        return new LottoPurchaseMoney(lottoPurchaseMoney);
    }

    private WinningNumbers getWinningNumbers() {
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        int bonusNumber = inputView.inputBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private LottoResult makeLottoResult(WinningNumbers winningNumbers, List<Lotto> lottoTickets) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lottoTicket : lottoTickets) {
            LottoRank rank = LottoRank.getRank(winningNumbers.countMatchWinningNumber(lottoTicket), winningNumbers.isMatchBonusNumber(lottoTicket));
            lottoResult.add(rank);
        }
        return lottoResult;
    }

}
