package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.dto.LottoStatsDTO;
import lotto.dto.LottoTicketDTO;

public class OutputView {
    private static final String INPUT_PAID_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFO_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_STATS_MESSAGE = "\n당첨 통계\n---";
    private static final String OUTPUT_YIELD_PERCENT = "총 수익률은 %.1f%%입니다.";
    private static final List<String> OUTPUT_LOTTO_RANK = List.of(
        "3개 일치 (5,000원) - %d개",
        "4개 일치 (50,000원) - %d개",
        "5개 일치 (1,500,000원) - %d개",
        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
        "6개 일치 (2,000,000,000원) - %d개");

    public static void printInputAmount() {
        System.out.println(INPUT_PAID_AMOUNT);
    }

    public static void printPaidLotto(Integer lottoCount, LottoTicketDTO lottoTicketDTO) {
        System.out.printf(INFO_LOTTO_COUNT, lottoCount / LottoNumberRule.LOTTO_PRICE.getValue());
        printLottoNumbers(lottoTicketDTO);
    }

    private static void printLottoNumbers(LottoTicketDTO paidLotto) {
        for (List<Integer> lottoNumber: paidLotto.getLottoTicket()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printStatsMessage(LottoStatsDTO lottoStatsDTO) {
        System.out.println(OUTPUT_STATS_MESSAGE);
        printLottoRank(lottoStatsDTO.getRankCounts());
        printYieldPercent(lottoStatsDTO.getYieldPercent());
    }

    public static void printLottoRank(List<Integer> rankCounts) {
        for (int rank = 0; rank < LottoNumberRule.LOTTO_MINIMUM_RANK.getValue(); ++rank) {
            System.out.printf(OUTPUT_LOTTO_RANK.get(rank), rankCounts.get(rank));
            System.out.println();
        }
    }

    private static void printYieldPercent(double yieldPercent) {
        System.out.printf(OUTPUT_YIELD_PERCENT, yieldPercent);
    }
}
