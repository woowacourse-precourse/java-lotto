package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> inputLottos;

    public Lottos(int number) {
        this.inputLottos = purchaseLotto(number);
    }

    public static List<Lotto> purchaseLotto(int number) {

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> unmodifiableNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            List<Integer> numbers = new ArrayList<>();
            for(Integer elem : unmodifiableNumbers)
                numbers.add(elem);
            Collections.sort(numbers);
            Lotto l = new Lotto(numbers);
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
