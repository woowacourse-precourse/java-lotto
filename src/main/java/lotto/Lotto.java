package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final String ERROR_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";

    private static final List<LottoItem> numbers = new ArrayList<>();
    private static final List<Lotto> number = new ArrayList<>();
    private static final List<LottoItem> initLottoNumbers = new ArrayList<>();
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final int lottoPrice = 1000;

    static {
        for (int i = 1; i <= 45; i++) {
            initLottoNumbers.add(new LottoItem(i));
        }
    }

    public Lotto(List<LottoItem> numbers) {
        validate(numbers);

        this.numbers.addAll(numbers);
    }

    private void validate(List<LottoItem> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }



    public static List<LottoItem> generateLottoNumbers() {
        Collections.shuffle(initLottoNumbers);
        List<LottoItem> lottoNumbers = initLottoNumbers.subList(0, 45);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public static void buy(Money money) {
        int countLottos = money.divide(lottoPrice);
        for (int i=0; i < countLottos; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    public static List<Lotto> getLottos() {
        return Collections.unmodifiableList(number);
    }

    public static List<LottoItem> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
