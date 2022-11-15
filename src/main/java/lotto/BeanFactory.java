package lotto;

import lotto.adapter.in.LottoController;
import lotto.application.port.in.LottoServiceUseCase;
import lotto.application.port.in.LottoWinningStatisticsUseCase;
import lotto.application.service.LottoService;
import lotto.application.service.LottoWinningStatisticsService;

public class BeanFactory {

    public static LottoServiceUseCase getLottoServiceUseCase() {
        return new LottoService();
    }

    public static LottoWinningStatisticsUseCase getLottoWinningStatisticsUseCase() {
        return new LottoWinningStatisticsService();
    }
}
