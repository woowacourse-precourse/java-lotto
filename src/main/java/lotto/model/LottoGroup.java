package lotto.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGroup {

    private final int LOTTO_COUNT;
    private final List<Lotto> LOTTO_LIST = new ArrayList<Lotto>();

    public LottoGroup(int buyAmount) {
        this.LOTTO_COUNT = buyLottoCount(buyAmount);
        for (int count = 0; count < LOTTO_COUNT; count++) {
            LottoNumberSave();
        }
    }

    private int buyLottoCount(int buyAmount) {
        return buyAmount / 1000;
    }

    private void LottoNumberSave() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        LOTTO_LIST.add(new Lotto(numbers));
    }

    public int getLOTTO_COUNT() {
        return LOTTO_COUNT;
    }

    public List<Lotto> getLOTTO_LIST() {
        return LOTTO_LIST;
    }


}
