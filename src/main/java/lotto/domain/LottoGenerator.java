package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LottoGenerator {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;


    public static LottoTickets generateTickets(Money money) {
        return Stream.generate(LottoGenerator::makeNewLotto)
                .limit(money.getTicketCount())
                .collect(collectingAndThen(toList(), LottoTickets::new));
    }

    private static Lotto makeNewLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }
}
