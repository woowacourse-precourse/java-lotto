package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {

    public int CalculateLottoCount() {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        return lottoCount;
    }

    public List<List<Integer>> createLotto() {
        List<List<Integer>> totalLotteries = new ArrayList<>();
        int lottoCount = CalculateLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            totalLotteries.add(numbers);
        }
        return totalLotteries;
    }
}
