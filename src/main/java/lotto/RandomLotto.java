package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLotto {
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private static int PICK_NUMBER = 6;

    public static Lotto randomLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER);
        return new Lotto(randomNumbers);
    }
}
