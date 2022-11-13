package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        List<String> stringNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            stringNumbers.add(number.toString());
        }

        return "[" + String.join(", ", stringNumbers) + "]";
    }

    public static List<Lotto> buyLottosByPurchaseMoney(int purchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = purchaseMoney / 1000;

        for (int i = 0; i < lottoNum; i++) {
            Lotto tempLotto = new Lotto(createSortedLottoNumbers(6));
            lottos.add(tempLotto);
        }

        return lottos;
    }

    public static List<Integer> createSortedLottoNumbers(int count) {
        final int LOTTO_START_NUMBER = 1;
        final int LOTTO_END_NUMBER = 45;

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, count);
        lottoNumbers.sort(null);

        return lottoNumbers;
    }
}
