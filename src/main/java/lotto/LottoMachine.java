package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public int CalculateLottoCount() {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> createLotto() {
        int lottoCount = CalculateLottoCount();
        List<List<Integer>> totalLotteries = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            totalLotteries.add(numbers);
        }
        return totalLotteries;
    }
}
