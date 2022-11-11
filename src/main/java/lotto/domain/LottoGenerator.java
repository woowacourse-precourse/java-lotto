package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public final static int LOTTO_PRICE = 1000;
    public final static int LOTTO_NUMBER_LENGTH = 6;
    public final static int LOTTO_NUMBER_MIN_VALUE = 1;
    public final static int LOTTO_NUMBER_MAX_VALUE = 45;

    public List<Lotto> createLottoBundle(int money) {
        int numberOfLottoToCreate = money / LOTTO_PRICE;
        
        return IntStream.range(0, numberOfLottoToCreate)
                .mapToObj(idx -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE, LOTTO_NUMBER_LENGTH
            )
        );
    }
}
