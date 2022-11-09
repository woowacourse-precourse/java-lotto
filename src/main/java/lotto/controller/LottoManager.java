package lotto.controller;

import lotto.util.RandomUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    InputView in = new InputView();
    OutputView out = new OutputView();

    private final int lottoPrice = 1000;

    public void run() {
        out.announceInputMoney();
        int money = in.inputNumber();
        int lottoCount = buyLotto(money);
        List<List<Integer>> boughtLottos = pickNumbers(lottoCount);
        out.printBoughtLotto(boughtLottos);

    }

    private int buyLotto(int money) {
        return money / lottoPrice;
    }

    private List<List<Integer>> pickNumbers(int lottoCount) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            result.add(RandomUtil.pickLottoNumbers());
        }

        return result;
    }

    private void calculateWins() {

    }

    private void calculateRatio() {

    }
}
