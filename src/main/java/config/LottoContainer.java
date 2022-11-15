package config;

import lotto.application.LottoService;
import lotto.application.LottoServiceImpl;
import lotto.infrastructure.LottoProvider;
import lotto.infrastructure.LottoProviderImpl;
import lotto.presentation.LottoGameController;
import lotto.presentation.view.LottoGamePrinter;
import lotto.presentation.view.LottoGameReader;

public class LottoContainer {

    private static LottoContainer lottoContainer;

    private LottoContainer() {
    }

    public static LottoContainer getInstance() {
        if (lottoContainer == null) {
            lottoContainer = new LottoContainer();
        }
        return lottoContainer;
    }
    public LottoGameController lottoController() {
        return new LottoGameController(lottoService(), lottoGameReader(), lottoGamePrinter());
    }

    public LottoProvider lottoProvider() {
        return new LottoProviderImpl();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoProvider());
    }

    public LottoGameReader lottoGameReader() {
        return new LottoGameReader(lottoGamePrinter());
    }

    public LottoGamePrinter lottoGamePrinter() {
        return new LottoGamePrinter();
    }
}
