package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> inputLottos;

    public Lottos(int number) {
        this.inputLottos = purchaseLotto(number);
    }

    public void printLottoNumbers() {
        inputLottos.stream().forEach(lotto -> System.out.println(lotto));
    }

    public static List<Lotto> purchaseLotto(int number) {

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto l = new Lotto(numbers);
            l.sortElements();
            lottoTickets.add(l);
        }

        return lottoTickets;
    }


}
