package lotto.config;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.repository.UserLottoRepository;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

	public LottoController config() {
		StatisticsService statisticsService = new StatisticsService();
		UserLottoRepository userLottoRepository = new UserLottoRepository();
		LottoService lottoService = new LottoService(userLottoRepository);
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		InputService inputService = new InputService();
		InputController inputController = new InputController(inputService, inputView);
		LottoController lottoController = new LottoController(lottoService, outputView, statisticsService,
			inputController);
		return lottoController;
	}

}
