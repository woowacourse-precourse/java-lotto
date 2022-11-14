package lotto.view.output;

import java.text.NumberFormat;
import java.util.List;
import java.util.StringJoiner;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.winning.Ranking;
import lotto.service.FinalResultsDto;

public class LottoFormat {

    private LottoFormat() {
    }

    static String purchasedNumberOfLottoTickets(int number) {
        final String PURCHASED_SUFFIX = "개를 구매했습니다.";
        return number + PURCHASED_SUFFIX;
    }

    static String lottoTickets(List<Lotto> purchasedLottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto purchasedLotto : purchasedLottoTickets) {
            stringBuilder
                    .append(purchasedLotto)
                    .append("\n");
        }

        return stringBuilder.toString();
    }

    static String errorMessage(String message) {
        final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
        return ERROR_MESSAGE_PREFIX + message;
    }

    static String finalResults(FinalResultsDto finalResultsDto) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        String rateOfReturnFormat = String.format("%,.1f", finalResultsDto.rateOfReturn());

        stringJoiner
                .add("당첨 통계")
                .add("---")
                .add(resultsFormat(finalResultsDto))
                .add("총 수익률은 " + rateOfReturnFormat + "%입니다.");

        return stringJoiner.toString();
    }

    private static String resultsFormat(FinalResultsDto finalResultsDto) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Ranking ranking : Ranking.values()) {
            stringBuilder
                    .append(rankingFormat(ranking)).append(" - ")
                    .append(finalResultsDto.count(ranking)).append("개\n");
        }

        return stringBuilder.toString();
    }

    private static String rankingFormat(Ranking ranking) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ranking.matchCounts()).append("개 일치");

        if (ranking.isMatchedBonus()) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        stringBuilder
                .append(" (")
                .append(NumberFormat.getNumberInstance().format(ranking.winnings()))
                .append("원)");

        return stringBuilder.toString();
    }
}
