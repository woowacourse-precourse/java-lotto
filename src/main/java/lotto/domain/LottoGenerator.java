package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    private static final int MAX_LEN = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final LottoConverter converter;

    public LottoGenerator() {
        this.converter = new LottoConverter();
    }

    public List<Lotto> getLottos(long playerLottoQuantity) {
        List<Lotto> playerLotto = new ArrayList<>();
        List<Integer> randomNumbers;
        Lotto lotto;
        for (int i = 0; i < playerLottoQuantity; i++) {
            randomNumbers = generateLottoNumbers();
            lotto = converter.convertRandomNumbersToLotto(randomNumbers);
            playerLotto.add(lotto);
        }
        return playerLotto;
    }

    private List<Integer> generateLottoNumbers() {
        return getRandomNumbers();
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, MAX_LEN);
    }


}
