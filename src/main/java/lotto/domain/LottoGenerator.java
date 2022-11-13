package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.LottoValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static List<Lotto> generate(String price) {
        return generate(Integer.parseInt(price));
    }

    public static List<Lotto> generate(Integer price) {
        final List<Lotto> lottoPacks = new ArrayList<>();
        final Integer count = getLottoCount(price);

        IntStream.rangeClosed(1, count).forEach(i -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            while (LottoValidator.isDuplication(numbers)) {
                numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            }

            numbers.sort(Comparator.comparing(Integer::intValue));
            lottoPacks.add(new Lotto(numbers));
        });

        return lottoPacks;
    }

    private static Integer getLottoCount(Integer price) {
        return price / 1000;
    }
}
