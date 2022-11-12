package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;

import java.util.List;

public class LottoMachine {

    public int CalculateLottoCount() {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        return lottoCount;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
