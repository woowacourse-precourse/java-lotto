package lotto.model;

import java.util.List;

public class LottoFactory {
    private static final LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.getInstance();

    private Lotto createLotto() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.create();
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }
}
