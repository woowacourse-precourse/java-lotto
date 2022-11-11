package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.LottoRandomPeek;

import java.util.ArrayList;
import java.util.List;

public class LottoRandomPeekOutput {
    public void output(List<Lotto> randomLottos){
        Output.checkBuyLotto(randomLottos);
    }
}
