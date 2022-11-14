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
            int lottoCount = getLottoCount(inputAmount());

            List<Lotto> lottos = generateLotto(lottoCount);
            outputLottoList(lottoCount, lottos);

            Win win = new Win(inputWinNumbers());
            win.setBonus(inputBonusNumber());

            outputWinningStats(lottoCount*1000, lottos, win);




        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getLottoCount(int amount) throws IllegalArgumentException {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERRER] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount / 1_000;
    }
}
