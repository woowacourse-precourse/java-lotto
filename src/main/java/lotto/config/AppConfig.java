package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.UserLottoRepository;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.util.InputUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

	public LottoController config() {
		StatisticsService statisticsService = new StatisticsService();
		UserLottoRepository userLottoRepository = new UserLottoRepository();
		LottoService lottoService = new LottoService(userLottoRepository);
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		InputUtil inputUtil = new InputUtil();
		LottoController lottoController = new LottoController(lottoService, outputView, inputView, statisticsService,
			inputUtil);
		return lottoController;
	}

}
