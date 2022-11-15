package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private static final String ERROR_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";

    private static List<Integer> numbers;
    private static final List<Lotto> number = new ArrayList<>();
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final Money lottoPrice = new Money(1000);


    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }

    public static Lotto generateLottoNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    public static void buy(Money money) {
        int countLottos = money.lottoAccount(lottoPrice);
        for (int i = 0; i < countLottos; i++) {
            lottos.add(generateLottoNumbers());
        }
    }

    public static List<Lotto> getLottos() {
        return Collections.unmodifiableList(number);
    }

    public static List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static LottoPrize confirmWinning(WinningNumbers winningNumbers) {
        int lottoNumberMatches = (int) numbers.stream()
                .filter(winningNumbers::hasLottoNumber)
                .count();
        int bonusNumberMatches = (int) numbers.stream()
                .filter(winningNumbers::hasBonusNumber)
                .count();

        return LottoPrize.match(lottoNumberMatches, bonusNumberMatches);
    }

    public static Map<LottoPrize, Integer> checkWinning(WinningNumbers winningNumbers) {
        Map<LottoPrize, Integer> result = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            result.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            LottoPrize prize = lotto.confirmWinning(winningNumbers);
            result.put(prize, result.get(prize) + 1);
        }

        return Collections.unmodifiableMap(result);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
