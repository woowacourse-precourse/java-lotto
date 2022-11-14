package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int ticketAmount) {
        generateNumber(ticketAmount);
        printNumber();
    }

    private void generateNumber(int ticketAmount) {
        for (int times = 0; times < ticketAmount; times++) {
            List<Integer> oneDrawNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(oneDrawNumber);
            Lotto oneLotto = new Lotto(oneDrawNumber);
            lottos.add(oneLotto);
        }
    }

    public void printNumber() {
        for (int oneLotto = 0; oneLotto < lottos.size(); oneLotto++) {
            System.out.println(lottos.get(oneLotto));
        }
    }
}
