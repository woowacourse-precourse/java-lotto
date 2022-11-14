package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoBunch {
    private ArrayList<Lotto> bunch;

    public LottoBunch(Integer size) {
        bunch = new ArrayList<>();
        for (int time = 0; time < size; time++) {
            Lotto lottoPaper = createLotto();
            bunch.add(lottoPaper);
        }
    }

    private Lotto createLotto() {
        List<Integer> rawNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lottoPaper = new Lotto(rawNumbers);
        return lottoPaper;
    }

    public ArrayList<Lotto> getLottoBunch() {
        ArrayList<Lotto> lottoBunch = new ArrayList<>();
        for (Lotto lotto : bunch) {
            lottoBunch.add(lotto);
        }
        return lottoBunch;
    }
}
