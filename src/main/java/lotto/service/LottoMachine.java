package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.correctLotto.CorrectLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int START_RANDOM = 1;
    private static final int END_RANDOM = 45;
    private static final int RANDOM_COUNT = 6;

    public static Lottos makeLottos(Money money) {
        int count = money.getCurrentMoney() / LOTTO_PRICE;
        money.paid(LOTTO_PRICE, count);

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANDOM, END_RANDOM, RANDOM_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public static CorrectLottoNumbers makeCorrectLotto(LottoNumbers correctNumbers, LottoNumber bonusNumber) {
        List<LottoNumber> combineCorrectLottoNumbers = combineCorrectLottoNumbers(correctNumbers, bonusNumber);

        List<LottoNumber> correctLottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : combineCorrectLottoNumbers) {
            correctLottoNumbers.add(lottoNumber);
        }
        return new CorrectLottoNumbers(correctLottoNumbers);
    }

    private static ArrayList<LottoNumber> combineCorrectLottoNumbers(LottoNumbers correctNumbers, LottoNumber bonusNumber) {
        ArrayList<LottoNumber> combineLottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : correctNumbers.getLottoNumbers()) {
            combineLottoNumbers.add(lottoNumber);
        }
        combineLottoNumbers.add(bonusNumber);
        return combineLottoNumbers;
    }
}

