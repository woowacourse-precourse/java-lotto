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

    public static void printLottoTicketCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_PURCHASE_COUNT);
    }

    public static void printTicket(LottoTicket lottoTicket) {
        for (Lotto lottoNumbers : lottoTicket.getLottoTickets()) {
            List<Integer> lottoNumberList = lottoNumbers.getNumbers();
            String sentence = joinList(convertToStringList(lottoNumberList));
            System.out.println(sentence);
        }
    }

    private static String joinList(List<String> list) {
        String str = String.join(DELIMITER + BLANK, list);
        return String.format("%s%s%s", OPEN_BRACKET, str, CLOSE_BRACKET);
    }

    private static List<String> convertToStringList(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
                .sorted()
                .map(lottoNumber -> Integer.toString((lottoNumber)))
                .collect(Collectors.toList());
    }
    public static void printLottoResult(LottoResult lottoResult){
        List<LottoRank> withoutDefault = LottoRank.getWithoutDefault();
        for (int i = withoutDefault.size() - 1; i >= 0 ; i--) {
            LottoRank rank = withoutDefault.get(i);
            System.out.printf(RESULT_RANK_MESSAGE,
                    rank.getCount(), printIfSecond(rank),
                    df.format(rank.getPrice()), lottoResult.getRankCount(rank));
        }
    }
    private static String printIfSecond(final LottoRank rank) {
        if (rank.equals(LottoRank.SECOND)) {
            return SAME_BONUS_MESSAGE;
        }
        return " ";
    }

    public static void printResultIntro() {
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
    }

    public static void printProfit(double profit) {
        String profitMessage = String.format("총 수익률은 %.1f%%입니다.", profit);
        System.out.println(profitMessage);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
