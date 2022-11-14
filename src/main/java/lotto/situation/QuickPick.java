package lotto.situation;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickPick {

    public static List<List<Integer>> bulkPick(int purchasesNumber) {
        List<List<Integer>> quickPicks = new ArrayList<>();
        for (int i = 0; i < purchasesNumber; i++) {
            quickPicks.add(create());
        }
        return quickPicks;
    }
    public static List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoState.START.number(), LottoState.END.number(), LottoState.LENGTH.number()
        );
        List<Integer> sortedNumber = new ArrayList<>(numbers);
        Collections.sort(sortedNumber);
        return sortedNumber;
    }
}
