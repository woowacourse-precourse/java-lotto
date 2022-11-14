package lotto.config;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.domain.RankGroup;
import lotto.repository.UserLottoRepository;
import lotto.service.InputValidService;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

	public LottoController config() {
		RankGroup rankGroup = new RankGroup();
		StatisticsService statisticsService = new StatisticsService(rankGroup);

		UserLottoRepository userLottoRepository = new UserLottoRepository();
		LottoService lottoService = new LottoService(userLottoRepository);
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		InputValidService inputValidService = new InputValidService();
		InputController inputController = new InputController(inputView, inputValidService);
		LottoController lottoController = new LottoController(lottoService, outputView, statisticsService,
			inputController);
		return lottoController;
	}

}
