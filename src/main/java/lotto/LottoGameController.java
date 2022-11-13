package lotto;

import view.IoView;
import dto.ScratchResult;
import java.util.Collections;
import java.util.List;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGameController {
    private IoView lottoGameView;
    private LottoPocket lottoPocket;

    public LottoGameController(IoView ioView){
        this.lottoGameView = ioView;
    }
    public void run() {
        try {
            int bill = lottoGameView.getBillFromUser();

            List<Lotto> lottos = Collections.unmodifiableList(LottoPublisher.publishLottos(bill));
            lottoGameView.printLottoPublishInfo(lottos);

            LottoPocket pocket = new LottoPocket(lottos);

            List<Integer> winningNumber = lottoGameView.getWinningNumbersFromUser();
            int bonusNumber = lottoGameView.getBonusNumberFromUser();
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

            ScratchResult scratchResult = pocket.getScratchResult(winningLotto);
            lottoGameView.printScratchResult(scratchResult);

        } catch (IllegalArgumentException e) {
            lottoGameView.printException(e);
        }
    }

}
