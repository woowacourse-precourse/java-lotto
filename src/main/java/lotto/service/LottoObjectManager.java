package lotto.service;

import lotto.util.converter.LottoInputConverter;

public class LottoObjectManager {

    private final LottoInputConverter inputConverter;

    public LottoObjectManager() {
        inputConverter = new LottoInputConverter();
    }
}
