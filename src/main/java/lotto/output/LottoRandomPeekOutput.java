package lotto.output;

import lotto.domain.Lotto;
import lotto.enums.StringEnum;

import java.util.List;

public class LottoRandomPeekOutput {
    public void output(List<Lotto> randomLottos){checkBuyLotto(randomLottos);
    }
    public void checkBuyLotto(List<Lotto> buyLottos) {
        int size = buyLottos.size();
        System.out.println(size + StringEnum.CHECK_LOTTO.getMessage());
        for (Lotto tempLotto : buyLottos) {
            System.out.println(tempLotto.getNumbers());
        }
        System.out.println();
    }

}
