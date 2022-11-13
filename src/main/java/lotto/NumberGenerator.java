package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    static final int STARTNUMBER = 1;
    static final int ENDNUMBER = 45;
    static final int COUNT = 6;

    public static List<Integer> creatNumber() {
        List<Integer> bundle = Randoms.pickUniqueNumbersInRange(STARTNUMBER, ENDNUMBER, 6);
        Collections.sort(bundle);
        return bundle;
    }
}
