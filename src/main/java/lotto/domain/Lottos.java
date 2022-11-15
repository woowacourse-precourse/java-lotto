package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> inputLottos;

    public Lottos(int number) {
        this.inputLottos = purchaseLotto(number);
    }

    public static List<Lotto> purchaseLotto(int number) {

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto l = new Lotto(numbers);
            l.sortNumbers();
            lottoTickets.add(l);
        }

        return lottoTickets;
    }

    public List<Lotto> getLottos() {
        return inputLottos;
    }

    public void printLottoNumbers() {
        inputLottos.forEach(System.out::println);
    }

}
