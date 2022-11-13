package lotto;

import java.util.Collections;
import java.util.List;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGameMachine {

    private LottoPocket lottoPocket;

    public void run() {
        try {
            int bill = IoManager.getBillFromUser();

            List<Lotto> lottos = Collections.unmodifiableList(LottoPublisher.publishLottos(bill));
            IoManager.printLottoPublishInfo(lottos);

            LottoPocket pocket = new LottoPocket(lottos);

            List<Integer> winningNumber = IoManager.getWinningNumbersFromUser();
            int bonusNumber = IoManager.getBonusNumberFromUser();
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

            ScratchResult scratchResult = pocket.getScratchResult(winningLotto);
            IoManager.printScratchResult(scratchResult);

        } catch (IllegalArgumentException e) {
            IoManager.printException(e);
        }
    }

}
