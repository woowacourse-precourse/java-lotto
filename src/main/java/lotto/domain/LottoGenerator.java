package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;


    public static LottoTickets generateTickets(Money money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        Stream.generate(LottoGenerator::makeNewLotto)
                .limit(money.getTicketCount())
                .forEach(lottoTickets::add);
        return new LottoTickets(lottoTickets);
    }

    private static Lotto makeNewLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }
}
