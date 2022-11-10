package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.ViewController;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int LOTTO_NUMBER_COUNT = 6;
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
}
