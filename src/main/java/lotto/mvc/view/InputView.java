package lotto.mvc.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.mvc.dto.input.InputBonusNumberDto;
import lotto.mvc.dto.input.InputPurchaseAmountDto;
import lotto.mvc.dto.input.InputWinningLottoDto;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.message.InputViewMessageUtils;

public final class InputView {

    private InputView() {
    }

    public static InputPurchaseAmountDto renderPurchaseAmount(final LottoGameStatus lottoGameStatus) {
        printWithLottoGameStatus(lottoGameStatus);
        return new InputPurchaseAmountDto(Console.readLine());
    }

    public static InputWinningLottoDto renderWinningLotto(final LottoGameStatus lottoGameStatus) {
        printWithLottoGameStatus(lottoGameStatus);
        return new InputWinningLottoDto(Console.readLine());
    }

    public static InputBonusNumberDto renderBonusNumber(final LottoGameStatus lottoGameStatus) {
        printWithLottoGameStatus(lottoGameStatus);
        return new InputBonusNumberDto(Console.readLine());
    }

    private static void printWithLottoGameStatus(final LottoGameStatus lottoGameStatus) {
        System.out.println(InputViewMessageUtils.findMessage(lottoGameStatus));
    }
}
