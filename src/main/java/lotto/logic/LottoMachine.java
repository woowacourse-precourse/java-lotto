package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoMachine {

    private static class LottoMachineHolder {
        private static final LottoMachine INSTANCE = new LottoMachine();
    }

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return LottoMachineHolder.INSTANCE;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
