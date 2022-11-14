package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.presentation.LottoPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final int startNumber;
    private final int endNumber;
    private final int numberCount;
    private final int priceUnit;
    private final LottoPrinter lottoPrinter;

    public LottoGenerator(int startNumber, int endNumber, int numberCount, int priceUnit, LottoPrinter lottoPrinter) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.numberCount = numberCount;
        this.priceUnit = priceUnit;
        this.lottoPrinter = lottoPrinter;
    }

    public List<Lotto> createLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int count = createLottoCount(price);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = createLotto();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberCount);
        return sortLottoNumbers(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private int createLottoCount(int price) {
        int count = price / priceUnit;
        lottoPrinter.printLottoCount(count);

        return count;
    }
}