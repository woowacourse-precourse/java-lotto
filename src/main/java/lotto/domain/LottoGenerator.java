package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumberParser.parseLottoNumbers;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private LottoGenerator() {
    }

    public static List<Lotto> buyMultipleRandomLotto(Money userMoney) {
        List<Lotto> userLottos = new ArrayList<>();
        int countOfLotto = userMoney.getCountOfLotto();
        for (int count = 0; count < countOfLotto; count++) {
            userLottos.add(getRandomLotto());
        }
        return userLottos;
    }

    private static Lotto getRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }

    public static Lotto getInputLotto(String inputLottoNumbers) {
        List<Integer> lottoNumbers = parseLottoNumbers(inputLottoNumbers);
        return new Lotto(lottoNumbers);
    }
}