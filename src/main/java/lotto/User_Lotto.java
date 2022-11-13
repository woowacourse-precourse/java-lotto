package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class User_Lotto {

    public static Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> create_all(int count) {
        List<Lotto> total_lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = create();
            System.out.println(lotto.numbers);
            total_lotto.add(lotto);
        }
        System.out.println();
        return total_lotto;
    }
}
