package lotto.adapter.in;

import lotto.application.port.in.LottoServiceUseCase;
import lotto.application.port.in.LottoWinningStatisticsUseCase;
import lotto.application.port.in.dto.*;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.view.BuyLottoView;
import lotto.view.LottoAnswerView;

public class LottoController {

    LottoServiceUseCase lottoServiceUseCase;
    LottoWinningStatisticsUseCase lottoWinningStatisticsUseCase;

    public LottoController(LottoServiceUseCase lottoServiceUseCase,
                           LottoWinningStatisticsUseCase lottoWinningStatisticsUseCase) {
        this.lottoServiceUseCase = lottoServiceUseCase;
        this.lottoWinningStatisticsUseCase = lottoWinningStatisticsUseCase;
    }

    ResponseBuyLottoDto handleBuyLotto(String inputMoney) {
        RequestBuyLottoDto requestBuyLottoDto = new RequestBuyLottoDto(inputMoney);
        return lottoServiceUseCase.buyLotto(requestBuyLottoDto);
    }

    ResponseMatchDto handleMatch(String inputNumber, String bonusNumber, ResponseBuyLottoDto requestDto) {
        Lotto winningLotto = lottoServiceUseCase.ConvertLotto(inputNumber);
        Bonus bonus = new Bonus(bonusNumber);

        RequestMatchDto requestMatchDto = new RequestMatchDto(winningLotto, bonus, requestDto);
        return lottoServiceUseCase.matchWinningNumber(requestMatchDto);
    }

    ResponseAnalyzeRevenueDto handleRevenue(ResponseMatchDto requestDto, int count) {
        RequestAnalyzeRevenueDto requestAnalyzeRevenueDto =
                new RequestAnalyzeRevenueDto(requestDto.getRewardTable());
        return lottoWinningStatisticsUseCase.analyzeRevenue(requestAnalyzeRevenueDto, count);
    }
}
