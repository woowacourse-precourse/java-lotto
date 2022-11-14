package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.utils.Validator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private final InputView inputView = new InputView();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Validator validator = new Validator();

    public LottoSystem() {}

    public void start() {
        String input = inputView.inputMoney();
        int money = validator.convertToInt(input);
        List<Lotto> userLottos = buyLotto(money);
        // 아래 코드는 테스트용
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private List<Lotto> buyLotto(int money) {
        int lottoCnt = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}