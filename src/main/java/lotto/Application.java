package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<Lotto> generatedLottos = generateLottos(InputView.getGeneratedLottoCount());

            WinLotto winLotto = new WinLotto(InputView.getWinLottoNumbers(), InputView.getWinBonusNumber());

            OutputView.showStatistics(generatedLottos, winLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            System.out.println(lotto.printNumbers());
            generatedLottos.add(lotto);
        }
        return generatedLottos;
    }
}
