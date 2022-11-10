package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.InputConfig;
import lotto.controller.ViewController;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int START_INCLUSIVE = InputConfig.START_INCLUSIVE;
    private final int END_INCLUSIVE = InputConfig.END_INCLUSIVE;
    private final int LOTTO_NUMBER_COUNT = InputConfig.LOTTO_NUMBER_COUNT;
    private final ViewController viewController;

    public LottoGenerator() {
        this.viewController = new ViewController();
    }

    public List<Lotto> getLottoList() {
        long amount = viewController.inputPurchaseAmount();

        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add(getLotto());
        }
        viewController.printPurchasedLotto(list);
        return list;
    }

    private Lotto getLotto() {
        List<Integer> numbers = generateLottoNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNum);
        return lottoNum;
    }

    public Lotto forTest_getLotto() {
        return getLotto();
    }
}
