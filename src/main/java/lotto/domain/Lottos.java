package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Preset.*;

public class Lottos {
    private final List<Lotto> purchaseLottos;

    public Lottos(int number) {
        this.purchaseLottos = purchaseLotto(number);
    }

    public static List<Lotto> purchaseLotto(int purchaseNumber) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> unmodifiableNumbers = getLottoNumbers();

            List<Integer> numbers = convertToSortedList(unmodifiableNumbers);
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_LENGTH);
    }

    public static List<Integer> convertToSortedList(List<Integer> unmodifiableNumbers) {

        List<Integer> numbers = new ArrayList<>(unmodifiableNumbers);
        Collections.sort(numbers);

        return numbers;
    }

    public List<Lotto> getLottos() {
        return purchaseLottos;
    }

    public void printLottoNumbers() {
        purchaseLottos.forEach(System.out::println);
    }

}
