package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Ouput;

public class LottoMachine {
    private List<Lotto> lottoTable = new ArrayList<>();

    public List<Integer> getRandomNumbers() {
        return new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public int getAmount(int won) {
        if (won % Lotto.PRICE != 0 || won == 0) {
            throw new IllegalArgumentException(Ouput.ENTER_IN_UNITS_OF_1000_WON_ERROR);
        }
        return won / Lotto.PRICE;
    }

    public void purchaseLottoTable(int won) {
        lottoTable.clear();
        for (int i = 0; i < getAmount(won); i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
            lottoTable.add(lotto);
        }
    }
    public List<Lotto> getLottoTable() {
        return lottoTable;
    }
}
