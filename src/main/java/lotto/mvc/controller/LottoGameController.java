package lotto.mvc.controller;

import lotto.domain.player.LottoPurchaseAmount;
import lotto.mvc.dto.input.InputBonusNumberDto;
import lotto.mvc.dto.input.InputPurchaseAmountDto;
import lotto.mvc.dto.input.InputWinningLottoDto;
import lotto.mvc.dto.output.OutputExceptionMessageDto;
import lotto.mvc.dto.output.OutputLottoStatisticsDto;
import lotto.mvc.dto.output.OutputPlayerInfoDto;
import lotto.mvc.model.LottoResult;
import lotto.mvc.model.LottoStore;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.NotFoundViewMessageException;
import lotto.mvc.util.exception.WrongGameStatusException;
import lotto.mvc.view.InputView;
import lotto.mvc.view.OutputView;
import lotto.util.message.CommonMessageConst;
import lotto.util.number.LottoNumberFactory;

public class LottoGameController {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "예기치 못한 문제가 발생했습니다.";

    private LottoStore lottoStore;

    public LottoGameStatus process(final LottoGameStatus lottoGameStatus) {
        try {
            return playLottoGame(lottoGameStatus);
        } catch (IllegalArgumentException | NotFoundViewMessageException | WrongGameStatusException e) {
            OutputView.renderExceptionMessage(
                    new OutputExceptionMessageDto(CommonMessageConst.LINE_FEED + e.getMessage()));
        } catch (Exception e) {
            OutputView.renderExceptionMessage(new OutputExceptionMessageDto(createApplicationExceptionMessage()));
        }
        return LottoGameStatus.APPLICATION_EXCEPTION;
    }

    private LottoGameStatus playLottoGame(final LottoGameStatus lottoGameStatus) {
        if (lottoGameStatus == LottoGameStatus.PURCHASE_AMOUNT) {
            return processLottoPurchaseAmount(lottoGameStatus);
        }
        if (lottoGameStatus == LottoGameStatus.WINNING_NUMBERS) {
            return processWinningLotto(lottoGameStatus);
        }
        if (lottoGameStatus == LottoGameStatus.BONUS_NUMBER) {
            return processBonusNumber(lottoGameStatus);
        }
        throw new WrongGameStatusException();
    }

    private LottoGameStatus processLottoPurchaseAmount(final LottoGameStatus lottoGameStatus) {
        InputPurchaseAmountDto inputPurchaseAmountDto = InputView.renderPurchaseAmount(lottoGameStatus);

        lottoStore = new LottoStore(new LottoPurchaseAmount(inputPurchaseAmountDto.getInputPurchaseAmount()));

        OutputView.renderPlayerLotto(new OutputPlayerInfoDto(lottoStore));
        return lottoGameStatus.findNextGameStatus();
    }

    private LottoGameStatus processWinningLotto(final LottoGameStatus lottoGameStatus) {
        InputWinningLottoDto inputWinningLottoDto = InputView.renderWinningLotto(lottoGameStatus);

        lottoStore.createWinningLotto(inputWinningLottoDto.getInputWinningLotto());
        return lottoGameStatus.findNextGameStatus();
    }

    private LottoGameStatus processBonusNumber(final LottoGameStatus lottoGameStatus) {
        InputBonusNumberDto inputBonusNumberDto = InputView.renderBonusNumber(lottoGameStatus);

        LottoResult lottoResult = lottoStore.calculateLottoResult(
                LottoNumberFactory.numberOf(inputBonusNumberDto.getInputBonusNumber()));

        OutputView.renderLottoStatistics(new OutputLottoStatisticsDto(lottoResult));
        return lottoGameStatus.findNextGameStatus();
    }

    private String createApplicationExceptionMessage() {
        return CommonMessageConst.LINE_FEED + CommonMessageConst.EXCEPTION_MESSAGE_PREFIX + DEFAULT_EXCEPTION_MESSAGE;
    }
}
