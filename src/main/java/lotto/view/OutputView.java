package lotto.view;

import java.util.List;
import lotto.dto.LottoStatsDTO;
import lotto.dto.LottoTicketDTO;

public class OutputView {
    public static void printInputAmount() {
        System.out.println(OutputMessage.INPUT_PAID_AMOUNT.getValue());
    }

    public static void printPaidLotto(Integer lottoCount, LottoTicketDTO lottoTicketDTO) {
        System.out.printf(
            OutputMessage.INFO_LOTTO_COUNT.getValue(),
            lottoCount / LottoNumberRule.LOTTO_PRICE.getValue()
        );
        printLottoNumbers(lottoTicketDTO);
    }

    private static void printLottoNumbers(LottoTicketDTO paidLotto) {
        for (List<Integer> lottoNumber : paidLotto.getLottoTicket()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printInputWinningNumber() {
        System.out.println(
            OutputMessage.INPUT_WINNING_NUMBER.getValue()
        );
    }

    public static void printInputBonusNumber() {
        System.out.println(
            OutputMessage.INPUT_BONUS_NUMBER.getValue());
    }

    public static void printStatsMessage(LottoStatsDTO lottoStatsDTO) {
        System.out.println(
            OutputMessage.OUTPUT_STATS_MESSAGE.getValue()
        );
        printLottoRank(lottoStatsDTO.getRankCounts());
        printYieldPercent(lottoStatsDTO.getYieldPercent());
    }

    public static void printLottoRank(List<Integer> rankCounts) {
        for (int rank = 0; rank < LottoNumberRule.LOTTO_MINIMUM_RANK.getValue(); ++rank) {
            System.out.printf(OutputLottoResult.of(rank).getValue(), rankCounts.get(rank));
            System.out.println();
        }
    }

    private static void printYieldPercent(double yieldPercent) {
        System.out.printf(
            OutputMessage.OUTPUT_YIELD_PERCENT.getValue(),
            yieldPercent
        );
    }
}
