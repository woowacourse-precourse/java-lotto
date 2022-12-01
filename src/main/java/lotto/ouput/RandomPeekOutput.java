package lotto.ouput;

import lotto.domain.Lotto;
import lotto.enums.StringEnum;

import java.util.List;

import static lotto.enums.StringEnum.*;

public class RandomPeekOutput {
    public void output(List<Lotto> randomLottos){checkBuyLotto(randomLottos);
    }
    public void checkBuyLotto(List<Lotto> buyLottos) {
        int size = buyLottos.size();
        System.out.println(size + CHECK_LOTTO.getMessage());
        for (Lotto tempLotto : buyLottos) {
            System.out.println(tempLotto);
        }
        System.out.println();
    }
}
