package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<Lotto> generatedLottos = Util.generateLottos(InputView.getGeneratedLottoCount());

            WinLotto winLotto = new WinLotto(InputView.getWinLottoNumbers(), InputView.getWinBonusNumber());

            OutputView.showStatistics(generatedLottos, winLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
