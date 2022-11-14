package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.Output;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final List<Lotto> quickPicks;
    private final int MIN_UNIT = 1000;

    public NumberGenerator() {
        this.quickPicks = new ArrayList<>();
    }

    public List<Lotto> getQuickPick(int input) {
        int quickPickAmt = input / MIN_UNIT;
        while (quickPicks.size() < quickPickAmt) {
            Lotto quickPick = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            quickPicks.add(quickPick);
        }
        Output.printQuickPick(quickPicks);

        return quickPicks;
    }
}
