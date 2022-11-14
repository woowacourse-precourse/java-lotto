package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String BLANK = " ";
    private static final String DELIMITER = ",";
    private static final String TICKET_PURCHASE_COUNT = "개를 구매했습니다.";

    private static final String SAME_BONUS_MESSAGE = ", 보너스 볼 일치 ";

    private static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개" + System.lineSeparator();
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static DecimalFormat df = new DecimalFormat("###,###");

    private OutputView() {
    }
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
