package lotto.domain.game.randomlottosystem;

import java.util.List;
import lotto.domain.lotto.LottoBundle;
import lotto.system.IoSystem;

public class RandomLottoSystem {
    private final IoSystem io;

    public RandomLottoSystem(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    public LottoBundle generateLottoBundle(List<List<Integer>> numbers) {
        io.println(numbers.size() + "개를 구매했습니다.");

        var lottoBundle = new LottoBundle(numbers);

        io.println(lottoBundle.listUpLotto());

        return lottoBundle;
    }

}
