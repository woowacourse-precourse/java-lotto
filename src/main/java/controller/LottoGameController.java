package controller;

import domain.Lotto;
import domain.LottoPocket;
import domain.LottoPublisher;
import domain.WinningLotto;
import dto.ScratchResult;
import java.util.Collections;
import java.util.List;
import view.InputView;
import view.OutputView;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGameController {

    private InputView inputView;
    private OutputView outputView;
    private LottoPocket lottoPocket;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            List<Lotto> lottos = publishLotto(inputView.getBillFromUser());
            lottoPocket = new LottoPocket(lottos);
            outputView.printLottoPublishInfo(lottos);

            Lotto winningNumbers = new Lotto(inputView.getWinningNumbersFromUser());
            int bonusNumber = inputView.getBonusNumberFromUser();

            ScratchResult scratchResult = getScratchResult(winningNumbers, bonusNumber);
            outputView.printScratchResult(scratchResult);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private List<Lotto> publishLotto(int money) {
        return Collections.unmodifiableList(LottoPublisher.publishLottos(money));
    }

    private ScratchResult getScratchResult(Lotto winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return lottoPocket.getScratchResult(winningLotto);
    }
}
