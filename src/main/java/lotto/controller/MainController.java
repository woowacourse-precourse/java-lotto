package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void run() {
        Money money = new Money(InputView.inputMoney());
        List<Lotto> lottoList = makeLotto(money.getLottoCount());
        OutputView.printLottoList(lottoList);
        WinLotto winLotto = makeWinLotto();
        int bonusNum = winLotto.validateBonus(InputView.inputBonusNum());
        
    }

    private static List<Lotto> makeLotto(int count) {
        List<List<Integer>> lottoNumList = generateNum(count);
        List<Lotto> lottoList = new ArrayList<>();

        for (List<Integer> lottoNum : lottoNumList) {
            lottoList.add(new Lotto(lottoNum));
        }
        return lottoList;
    }

    private static WinLotto makeWinLotto() {
        String input = InputView.inputWinLotto();
        WinLotto winLotto = new WinLotto(input);
        return winLotto;
    }



    private static List<List<Integer>> generateNum(int count) {
        List<List<Integer>> lottoNumList = new ArrayList<>();

        while (lottoNumList.size() < count) {
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (!lottoNumList.contains(lottoNum)) {
                lottoNumList.add(lottoNum);
            }
        }

        return lottoNumList;
    }
}
