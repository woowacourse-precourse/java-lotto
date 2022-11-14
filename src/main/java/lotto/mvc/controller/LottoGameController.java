package lotto.mvc.controller;

import lotto.domain.player.LottoPurchaseAmount;
import lotto.mvc.model.LottoResult;
import lotto.mvc.model.LottoStore;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.NotFoundViewMessageException;
import lotto.mvc.util.message.InputViewMessageUtils;
import lotto.mvc.view.ConsoleView;
import lotto.util.message.CommonMessageConst;
import lotto.util.number.LottoNumberFactory;

public class LottoGameController {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "예기치 못한 문제가 발생했습니다.";

    private LottoStore lottoStore;
    private LottoResult lottoResult;

    public LottoGameStatus process(LottoGameStatus lottoGameStatus, String playerInput) {
        if (lottoGameStatus.isInput()) {
            return renderInputView(lottoGameStatus);
        }
        if (lottoGameStatus.isLogic()) {
            return handle(lottoGameStatus, playerInput);
        }
        return lottoGameStatus.findNextGameStatus();
    }

    private LottoGameStatus renderInputView(LottoGameStatus lottoGameStatus) {
        ConsoleView.render(findInputViewMessage(lottoGameStatus));
        return lottoGameStatus.findNextGameStatus();
    }

    private String findInputViewMessage(LottoGameStatus lottoGameStatus) {
        return InputViewMessageUtils.findMessage(lottoGameStatus);
    }

    private LottoGameStatus renderOutputView(LottoGameStatus lottoGameStatus) {
        if (lottoGameStatus == LottoGameStatus.PROCESS_WINNING_LOTTO) {
            return lottoGameStatus.findNextGameStatus();
        }

        ConsoleView.render(findOutputViewMessage(lottoGameStatus));
        return lottoGameStatus.findNextGameStatus();
    }

    private String findOutputViewMessage(LottoGameStatus lottoGameStatus) {
        if (lottoGameStatus == LottoGameStatus.PROCESS_PURCHASE_LOTTO) {
            return lottoStore.findPlayerInfo();
        }
        return lottoResult.toString();
    }

    private LottoGameStatus handle(LottoGameStatus lottoGameStatus, String playerInput) {
        try {
            processDetailLogic(lottoGameStatus, playerInput);
            return renderOutputView(lottoGameStatus);
        } catch (IllegalArgumentException | NotFoundViewMessageException e) {
            return renderExceptionView(CommonMessageConst.LINE_FEED + e.getMessage());
        } catch (Exception e) {
            return renderExceptionView(processApplicationExceptionMessage());
        }
    }

    private String processApplicationExceptionMessage() {
        return CommonMessageConst.LINE_FEED + CommonMessageConst.EXCEPTION_MESSAGE_PREFIX + DEFAULT_EXCEPTION_MESSAGE;
    }

    private LottoGameStatus renderExceptionView(String message) {
        ConsoleView.render(message);
        return LottoGameStatus.APPLICATION_EXCEPTION;
    }

    private void processDetailLogic(LottoGameStatus lottoGameStatus, String playerInput) {
        if (lottoGameStatus == LottoGameStatus.PROCESS_PURCHASE_LOTTO) {
            lottoStore = new LottoStore(new LottoPurchaseAmount(playerInput));
            return;
        }
        if (lottoGameStatus == LottoGameStatus.PROCESS_WINNING_LOTTO) {
            lottoStore.createWinningLotto(playerInput);
            return;
        }
        lottoResult = lottoStore.calculateLottoResult(LottoNumberFactory.numberOf(playerInput));
    }
}
