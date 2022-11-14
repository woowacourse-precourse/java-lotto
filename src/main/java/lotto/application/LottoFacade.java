package lotto.application;

import lotto.domain.LottoProcessor;
import lotto.domain.LottoProcessorImpl;

public class Facade {

    private final LottoProcessor lottoProcessor = new LottoProcessorImpl();


}
