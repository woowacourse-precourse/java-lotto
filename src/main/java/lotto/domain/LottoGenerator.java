package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.LottoAttributes.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoAttributes.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoAttributes.MAX_LOTTO_NUMBERS_SIZE;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {

    public static List<Lotto> publish(final int numberOfTickets) {
        return Stream.generate(() -> new Lotto(getNonDuplicateNumbers()))
            .limit(numberOfTickets)
            .sorted(Comparator.comparingInt(Lotto::getSumOfNumbers))
            .collect(Collectors.toList());
    }

    private static List<Integer> getNonDuplicateNumbers() {
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
            MAX_LOTTO_NUMBER, MAX_LOTTO_NUMBERS_SIZE);
    }
}
