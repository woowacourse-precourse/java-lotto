package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    private RandomLotto randomLotto = new RandomLotto();

    public List<Lotto> getRandomLottos(int lottoTicket) {
        List<Lotto> resultLottos = new ArrayList<>();
        for (int i = 0; i < lottoTicket; i++) {
            resultLottos.add(getSingleRandomLotto());
        }
        return resultLottos;
    }

    public Lotto getSingleRandomLotto() {
        return randomLotto.getRandomLotto();
    }

    public Lotto getManualLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

}
