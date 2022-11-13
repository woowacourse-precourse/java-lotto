package lotto.view.input;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    LottoGenerator lottoGenerator = new LottoGenerator();
    List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateLottos(int size) {
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

}
