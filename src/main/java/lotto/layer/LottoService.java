package lotto.layer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class LottoService {

    Table table;

    public LottoService(Table table) {
        this.table = table;
    }

    public List<Lotto> generateLotteries(Money money) {
        table.clear();
        int lottoCount = money.intValue() / Money.UNIT;
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_VALUE,
                    LottoNumber.MAX_VALUE, Lotto.LOTTO_LENGTH);
            lotteries.add(new Lotto(uniqueNumbersInRange));
        }
        table.saveLottoAll(lotteries);
        table.saveMoney(money);
        return lotteries;
    }
}