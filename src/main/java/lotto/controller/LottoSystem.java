package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private static final InputView inputView = new InputView();
    private static final NumberGenerator numberGenerator = new NumberGenerator();

    public LottoSystem() {}

    public void start() {
        String userPrice = inputView.inputPrice();
        List<Lotto> userLottos = buyLotto(userPrice);
    }

    private List<Lotto> buyLotto(String price) {
        int cnt = Integer.parseInt(price) / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}