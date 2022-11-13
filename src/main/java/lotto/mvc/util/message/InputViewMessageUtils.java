package lotto.mvc.util.message;

import java.util.Arrays;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.NotFoundViewMessageException;

public enum InputViewMessageUtils {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요.", LottoGameStatus.GUIDE_PURCHASE_AMOUNT),
    WINNING_NUMBERS("\n당첨 번호를 입력해 주세요.", LottoGameStatus.GUIDE_WINNING_NUMBERS),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.", LottoGameStatus.GUIDE_BONUS_NUMBER);

    private final String message;
    private final LottoGameStatus lottoGameStatus;

    InputViewMessageUtils(String message, LottoGameStatus lottoGameStatus) {
        this.message = message;
        this.lottoGameStatus = lottoGameStatus;
    }

    public static String findMessage(LottoGameStatus lottoGameStatus) {
        return Arrays.stream(InputViewMessageUtils.values())
                .filter(utils -> utils.lottoGameStatus == lottoGameStatus)
                .map(utils -> utils.message)
                .findAny()
                .orElseThrow(NotFoundViewMessageException::new);
    }
}
