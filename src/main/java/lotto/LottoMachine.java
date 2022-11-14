package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final Integer UNIT = 1000;
    private static final Integer NUMBER_RANGE_BOT = 1;
    private static final Integer NUMBER_RANGE_TOP = 45;
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    public static List<Lotto> getRandomLottos(Integer money) {
        List<Lotto> lottos = new ArrayList<>();
        Integer numberOfLotto = money % UNIT;

        for (int count = 0; count < numberOfLotto; count++) {
            lottos.add(Lotto.numberOf(getRandomLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_BOT, NUMBER_RANGE_TOP, LOTTO_NUMBER_SIZE);
    }
}
