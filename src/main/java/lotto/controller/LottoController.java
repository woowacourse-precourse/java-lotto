package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.vo.LottoInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        OutputView.printStartMesseage();
        int purchaseMoney = InputView.getPurchase();
        LottoGame lottoGame = new LottoGame(purchaseMoney);
        List<Lotto> lottos = lottoGame.getUserLottos();
        OutputView.printLottoNumber(purchaseMoney / 1000);
        OutputView.printLotto(lottos);

        OutputView.printRequestWinningNumber();
        List<Integer> winningNumber = InputView.getWinningNumber();

        OutputView.printRequestBonusNumber();
        int bonusNumber = InputView.getBonusNumber();

        LottoInfo lottoInfo = new LottoInfo(winningNumber, bonusNumber);
    }
}
