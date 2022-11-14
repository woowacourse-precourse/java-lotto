package lotto;

import lotto.domain.Lotto;
import lotto.view.Output;

import java.util.List;

import static lotto.LottoGenerator.generateLotto;
import static lotto.view.Input.*;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoCount = getLottoCount(inputAmount());

            List<Lotto> lottos = generateLotto(lottoCount);
            Output.outputLottoList(lottoCount, lottos);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getLottoCount(String input) throws IllegalArgumentException {
        try {
            int amount = Integer.parseInt(input);
            if (amount < 1000 || amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERRER] 구입금액은 1,000원 단위로 입력해야 합니다.");
            }
            return amount / 1_000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

}
