package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    public Lotto draw() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> draw(int count) {
        List<Lotto> lottos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lottos.add(draw());
        }

        return lottos;
    }

    public int compare(Lotto winningLotto, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

}
