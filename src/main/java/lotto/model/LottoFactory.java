package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.getInstance();

    public List<Lotto> createLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.create();
        return new Lotto(lottoNumbers);
    }
}
