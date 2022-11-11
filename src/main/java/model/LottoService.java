package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public List<Lotto> issueLotto(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < getCount(money); i++) {
            List<Integer> numbers = createLottoNumbers();
            Collections.sort(numbers);
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LottoStatus.START.getValue(),
                        LottoStatus.END.getValue(),
                        LottoStatus.SIZE.getValue());
    }

    private int getCount(int money) {
        return money / LottoStatus.PRICE.getValue();
    }
}
