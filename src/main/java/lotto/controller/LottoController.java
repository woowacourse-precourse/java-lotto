package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RankingResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private int lottoAmount;
    LottoNumber lottoNumber;
    LottoTickets lottoTickets;
    LottoBonusNumber lottoBonusNumber;
    RankingResult rankingResult;
    Money money;

    public void start() {
        money = inputLottoMoney();
        LottoTickets lottoTickets = purchaseLotto(lottoAmount);
        LottoNumber lottoNumber = inputLottoNumber();
        LottoBonusNumber lottoBonusNumber = inputLottoBonusNumber();
        getRanking();
        OutputView.printResult(rankingResult,money);

    }
    public void getRanking(){
        Lotto lotto = new Lotto(lottoNumber.getLottoNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(lotto, lottoTickets,lottoBonusNumber.getBonusNumber());
        rankingResult = winningNumbers.createRanking();

    }

    public LottoNumber inputLottoNumber() {
        lottoNumber = new LottoNumber(InputView.numbersInput());
        return lottoNumber;
    }

    public Money inputLottoMoney() {
        Money money = new Money(InputView.moneyInput());
        lottoAmount = money.calculateLottoAmount();
        OutputView.printPurchaseLotto(lottoAmount);
        return money;
    }

    public LottoBonusNumber inputLottoBonusNumber() {
        lottoBonusNumber = new LottoBonusNumber(InputView.bonusNumberInput());

        return lottoBonusNumber;
    }

    public LottoTickets purchaseLotto(int lottoAmount) {
        lottoTickets = new LottoTickets(lottoAmount);
        OutputView.printLottoPaper(lottoTickets);
        return lottoTickets;
    }

}
