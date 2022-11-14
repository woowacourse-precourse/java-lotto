package lotto;

import lotto.domain.WinningType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    private static final String BUY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_NUMBER_MESSAGE = "{0}개를 구매했습니다.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_INFO_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 {0,number,.#}%입니다.";
    private static final String BLANK_LINE = "\n";

    public static final List<String> PRIZE_DESC = Arrays.stream(WinningType.values())
            .map(WinningType::getDesc)
            .collect(Collectors.toList());
}