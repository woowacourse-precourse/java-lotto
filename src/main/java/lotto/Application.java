package lotto;

import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.List;

import static lotto.utils.LottoGenerator.generateLotto;
import static lotto.view.Input.*;
import static lotto.view.Input.inputWinNumbers;
import static lotto.view.Output.outputLottoList;
import static lotto.view.Output.outputWinningStats;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoCount = inputAmount() / 1_000;

            List<Lotto> lottos = generateLotto(lottoCount);
            outputLottoList(lottoCount, lottos);

            Win win = new Win(inputWinNumbers());
            win.setBonus(inputBonusNumber());

            outputWinningStats(lottoCount * 1000, lottos, win);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
