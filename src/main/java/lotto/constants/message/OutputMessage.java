package lotto.constants.message;

import java.util.List;

public class OutputMessage {
    public static final String BOUGHT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDING_LINE = "---";
    public static final List<String> STATISTICS_FORMATS = List.of(
            "3개 일치 (5,000원) - %d개",
            "4개 일치 (50,000원) - %d개",
            "5개 일치 (1,500,000원) - %d개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            "6개 일치 (2,000,000,000원) - %d개"
    );
    public static final String EARNINGS_RATIO_FORMAT = "총 수익률은 %s%%입니다.";

    private OutputMessage() {
    }
}
