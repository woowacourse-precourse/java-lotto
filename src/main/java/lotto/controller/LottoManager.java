package lotto.controller;

import lotto.domain.LottoResult;
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
        out.announceBuyResult(lottoCount);
        out.printBoughtLotto(boughtLottos);
        out.announceInputWinNumber();
        List<Integer> winNumbers = in.inputNumbers();
        out.announceInputBonusNumber();
        int bonusNumber = in.inputNumber();

        calculateWins(boughtLottos, winNumbers, bonusNumber);
        out.announceResult();
        float profitRatio = calculateRatio();
        out.printProfitRatio(profitRatio);
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

    private List<LottoResult> calculateWins(List<List<Integer>> pickNumberList, List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> result = new ArrayList<>();

        for (List<Integer> pickNumbers : pickNumberList) {
            result.add(getGrade(winNumbers, bonusNumber, pickNumbers));
        }

        return result;
    }

    private LottoResult getGrade(List<Integer> winNumbers, int bonus, List<Integer> pickNumbers) {
        int count = 0;

        for (int number : pickNumbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }

        return gradeByHitCount(bonus, pickNumbers, count);
    }

    private LottoResult gradeByHitCount(int bonus, List<Integer> pickNumbers, int count) {
        if (count == 6) {
            return LottoResult.first;
        }
        if (count == 5 && pickNumbers.contains(bonus)) {
            return LottoResult.second;
        }
        if (count == 5 && !pickNumbers.contains(bonus)) {
            return LottoResult.third;
        }
        if (count == 4) {
            return LottoResult.fourth;
        }
        if (count == 3) {
            return LottoResult.fifth;
        }
        return LottoResult.none;
    }


    private float calculateRatio() {
        return 0f;
    }
}
