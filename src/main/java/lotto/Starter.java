package lotto;

import lotto.adapter.in.InputController;
import lotto.adapter.in.LottoController;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;
import lotto.application.port.in.dto.ResponseBuyLottoDto;
import lotto.application.port.in.dto.ResponseMatchDto;
import lotto.view.BuyLottoView;
import lotto.view.LottoAnswerView;
import lotto.view.ResultView;

public class Starter {
    LottoController lottoController;

    public Starter() {
        this.lottoController = new LottoController(BeanFactory.getLottoServiceUseCase(),
                BeanFactory.getLottoWinningStatisticsUseCase());
    }

    private ResponseBuyLottoDto buyLotto() {
        BuyLottoView.ask();
        ResponseBuyLottoDto responseBuyLottoDto = lottoController.handleBuyLotto(InputController.readMoney());
        int lottoNumber = responseBuyLottoDto.getLottos().size();
        BuyLottoView.printNumberOfLotto(lottoNumber);
        BuyLottoView.printLottos(responseBuyLottoDto.getLottos());

        return responseBuyLottoDto;
    }

    private ResponseMatchDto playLotto(ResponseBuyLottoDto requestDto) {
        LottoAnswerView.askAnswer();
        String inputNumber = InputController.readWinningNumber();
        LottoAnswerView.askBonusNumber();
        String bonusNumber = InputController.readWinningNumber();

        ResponseMatchDto responseMatchDto = lottoController.handleMatch(inputNumber, bonusNumber, requestDto);
        responseMatchDto.setLottoCount(requestDto.getLottos().size());

        return responseMatchDto;
    }

    private ResponseAnalyzeRevenueDto calculateRevenue(ResponseMatchDto requestDto) {
        return lottoController.handleRevenue(requestDto);
    }

    public void play() {
        try {
            ResponseBuyLottoDto buyLottoDto = buyLotto();
            ResponseMatchDto matchDto = playLotto(buyLottoDto);
            ResponseAnalyzeRevenueDto analyzeRevenueDto = calculateRevenue(matchDto);

            ResultView resultView = new ResultView(matchDto.getRewardTable(), analyzeRevenueDto.getRevenueAverage());
            resultView.print();
        } catch (IllegalArgumentException exception) {
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
