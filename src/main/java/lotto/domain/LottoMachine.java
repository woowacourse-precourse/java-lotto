package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Ouput;

public class LottoMachine {
    private List<Lotto> lottoTable = new ArrayList<>();

    public List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_OF_NUMBERS);
    }

    public int toAmount(int money) {
        if (money % Lotto.PRICE != 0 || money == 0) {
            throw new IllegalArgumentException(Ouput.ENTER_IN_UNITS_OF_1000_WON_ERROR);
        }
        return money / Lotto.PRICE;
    }

    public void purchaseLottoTable(int money) {
        lottoTable.clear();
        for (int row = 0; row < toAmount(money); row++) {
            Lotto lotto = new Lotto(createNumbers());
            lottoTable.add(lotto);
        }
    }

    public List<Lotto> getLottoTable() {
        return lottoTable;
    }
}
