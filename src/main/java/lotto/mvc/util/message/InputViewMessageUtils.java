package lotto.mvc.util.message;

import java.util.Arrays;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.NotFoundViewMessageException;
import lotto.util.message.CommonMessageConst;

public enum InputViewMessageUtils {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요.", LottoGameStatus.PURCHASE_AMOUNT),
    WINNING_NUMBERS(CommonMessageConst.LINE_FEED + "당첨 번호를 입력해 주세요.", LottoGameStatus.WINNING_NUMBERS),
    BONUS_NUMBER(CommonMessageConst.LINE_FEED + "보너스 번호를 입력해 주세요.", LottoGameStatus.BONUS_NUMBER);

    private final String message;
    private final LottoGameStatus lottoGameStatus;

    InputViewMessageUtils(String message, final LottoGameStatus lottoGameStatus) {
        this.message = message;
        this.lottoGameStatus = lottoGameStatus;
    }

    public static String findMessage(final LottoGameStatus lottoGameStatus) {
        return Arrays.stream(InputViewMessageUtils.values())
                .filter(utils -> utils.lottoGameStatus == lottoGameStatus)
                .map(utils -> utils.message)
                .findAny()
                .orElseThrow(NotFoundViewMessageException::new);
    }
}
