package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private static final String ERROR_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";

    private static final List<Integer> numbers = new ArrayList<>();
    private static final List<Lotto> number = new ArrayList<>();
    private static final List<LottoItem> initLottoNumbers = new ArrayList<>();
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final Money lottoPrice = new Money(1000);

    static {
        for (int i = 1; i <= 45; i++) {
            initLottoNumbers.add(new LottoItem(i));
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers.addAll(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }


    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(initLottoNumbers);
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public static void buy(Money money) {
        int countLottos = money.lottoAccount(lottoPrice);
        for (int i=0; i < countLottos; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
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
        for (Lotto lotto : lottos) {
            LottoPrize prize = confirmWinning(winningNumbers);
            result.put(prize, result.get(prize) + 1);
        }

        return result;
    }

}
