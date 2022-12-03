package lotto.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoResult;
import lotto.dto.input.ReadBonusNumberDto;
import lotto.dto.input.ReadPlayerPurchaseAmountDto;
import lotto.dto.input.ReadWinningLottoDto;
import lotto.dto.output.PrintExceptionMessageDto;
import lotto.dto.output.PrintLottoDto;
import lotto.dto.output.PrintLottoResultDto;
import lotto.utils.consts.LottoConst;
import lotto.utils.game.GameStatus;
import lotto.utils.number.LottoNumberFactory;
import lotto.utils.number.LottoNumbersGenerator;
import lotto.utils.number.LottoUniqueNumbersGenerator;
import lotto.view.IOViewResolver;
import lotto.view.exception.NotFoundViewException;

public class GameController {

    private static final String APPLICATION_EXCEPTION_MESSAGE = "애플리케이션 구성에 오류가 발생했습니다.";

    private final IOViewResolver ioViewResolver;
    private final Map<GameStatus, Supplier<GameStatus>> gameStatusMappings = new EnumMap<>(GameStatus.class);
    private LottoGame lottoGame;

    public GameController(IOViewResolver ioViewResolver) {
        this.ioViewResolver = ioViewResolver;
        initGameStatusMappings();
    }

    private void initGameStatusMappings() {
        gameStatusMappings.put(GameStatus.PURCHASE_AMOUNT, this::processPlayerPurchaseAmount);
        gameStatusMappings.put(GameStatus.WINNING_LOTTO, this::processWinningLotto);
        gameStatusMappings.put(GameStatus.BONUS_NUMBER, this::processLottoResult);
    }

    public GameStatus process(GameStatus gameStatus) {
        try {
            return gameStatusMappings.get(gameStatus).get();
        } catch (IllegalArgumentException e) {
            ioViewResolver.resolveOutputView(new PrintExceptionMessageDto(e.getMessage()));
        } catch (NotFoundViewException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(APPLICATION_EXCEPTION_MESSAGE);
        }
        return GameStatus.APPLICATION_EXCEPTION;
    }

    private GameStatus processPlayerPurchaseAmount() {
        ReadPlayerPurchaseAmountDto dto = ioViewResolver.resolveInputView(ReadPlayerPurchaseAmountDto.class);
        LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
                LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE);
        lottoGame = new LottoGame(dto.getPlayerPurchaseAmount(), generator);

        ioViewResolver.resolveOutputView(new PrintLottoDto(lottoGame.getPlayerPurchaseLottos()));
        return GameStatus.WINNING_LOTTO;
    }

    private GameStatus processWinningLotto() {
        ReadWinningLottoDto dto = ioViewResolver.resolveInputView(ReadWinningLottoDto.class);

        lottoGame.createWinningLotto(dto.getWinningLotto());
        return GameStatus.BONUS_NUMBER;
    }

    private GameStatus processLottoResult() {
        ReadBonusNumberDto dto = ioViewResolver.resolveInputView(ReadBonusNumberDto.class);

        LottoResult lottoResult = lottoGame.calculateLottoResult(LottoNumberFactory.numberOf(dto.getBonusNumber()));
        ioViewResolver.resolveOutputView(new PrintLottoResultDto(lottoResult));
        return GameStatus.APPLICATION_EXIT;
    }
}
