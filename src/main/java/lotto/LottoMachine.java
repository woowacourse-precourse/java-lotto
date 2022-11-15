package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_LIMIT_SIZE = 6;
    public static LottoCollection CreateWinningNumber(LottoCount lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount.getLottoCount();i++) {
            lottos.add(new Lotto(createRandomNumber()));
        }
        return new LottoCollection(lottos);
    }
    public static List<Integer> createRandomNumber() {
        List<Integer> numbers;

        numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,LOTTO_LIMIT_SIZE);
        Collections.sort(numbers);
        return numbers;
    }
}
