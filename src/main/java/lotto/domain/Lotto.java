package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
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
