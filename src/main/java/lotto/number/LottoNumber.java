package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LENGTH = 6;

    public List<Integer> generateLottoNumber() {
        List<Integer> winNumber = new ArrayList<Integer>();
        while (winNumber.size() < LENGTH) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!winNumber.contains(randomNumber)) {
                winNumber.add(randomNumber);
            }
        }
        Collections.sort(winNumber);

        return winNumber;
    }
}
