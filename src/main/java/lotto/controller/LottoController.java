package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Money;
import lotto.view.*;
import lotto.Lotto;

import java.util.List;

public class LottoController {
    private Money money;
    private InputView inputView;
    private OutputView outputView;
    private Lotto lotto;
    // 인스턴스 접근과, 임포트 접근 후 함수 호출 방식의 차이점은?
    public LottoController() {
    }
    public void init() {
        money = new Money();
        inputView = new InputView();
        outputView = new OutputView();

    }
    public void run() {
        init();
        inputView.purchaseLotto();
//        InputView.purchaseLotto();
        int purchaseMoney = Integer.valueOf(camp.nextstep.edu.missionutils.Console.readLine());
        saveMoney(purchaseMoney);
        outputView.lottoNumber(money.getMoney(), lotto);



    }
    public void saveMoney(int purchaseMoney) {
        money.setMoney(purchaseMoney);
    }
    public List<Integer> makeLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

}
