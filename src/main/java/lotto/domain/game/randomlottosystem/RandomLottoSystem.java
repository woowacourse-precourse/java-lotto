package lotto.domain.game.randomlottosystem;

import java.util.List;
import lotto.domain.lotto.LottoBundle;
import lotto.system.IoSystem;

public class RandomLottoSystem {


    public LottoBundle generateLottoBundle(List<List<Integer>> numbers) {
        IoSystem.println(numbers.size() + "개를 구매했습니다.");

        var lottoBundle = new LottoBundle(numbers);

        IoSystem.println(lottoBundle.listUpLotto());

        return lottoBundle;
    }

}
