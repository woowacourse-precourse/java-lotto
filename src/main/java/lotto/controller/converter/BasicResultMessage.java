package lotto.controller.converter;

import lotto.domain.info.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.info.Rank.EXTERIOR;

public class BasicResultMessage implements ResultMessage {
    private final DecimalFormat formatter = new DecimalFormat("###,###");
    private final DecimalFormat floatFormatter = new DecimalFormat("###,###.#");
    private final Rank[] rankValues = Rank.values();

    @Override
    public void printResult(final List<Rank> ranks, final int price) {
        String rankMessage = createRankMessage(ranks);
        String rateMessage = createRateMessage(ranks, price);

        System.out.println("당첨 통계 \n ---");
        System.out.print(rankMessage);
        System.out.println(rateMessage);
    }

    public String createRankMessage(final List<Rank> ranks) {
        StringBuilder builder = new StringBuilder();
        List<Rank> reverseRanksValues = Arrays.asList(rankValues);
        Collections.reverse(reverseRanksValues);

        for (Rank value : reverseRanksValues) {
            if (value == EXTERIOR) {
                continue;
            }
            builder.append(createMessageEachRank(value, ranks));
        }

        return builder.toString();
    }

    private String createMessageEachRank(final Rank value, final List<Rank> ranks) {
        StringBuilder builder = new StringBuilder();
        int rankCountInList = Collections.frequency(ranks, value);

        String bonusMessage = "";
        if (value.isBonus()) {
            bonusMessage = ", 보너스 볼 일치 ";
        }
        String price = formatter.format(value.getPrice());
        return String.format("%d개 일치%s (%s원) - %d개 \n", value.getCount(), bonusMessage, price, rankCountInList);
    }

    public String createRateMessage (final List<Rank> ranks, final int price) {
        int sum = 0;
        for (Rank rank : ranks) {
            sum += rank.getPrice();
        }

        double rate = calculateRate(sum, price);

        String rateFormat = floatFormatter.format(rate);
        if (!rateFormat.contains(".")) {
            rateFormat += ".0";
        }

        return "총 수익률은 "+rateFormat+"%입니다.";
    }

    private double calculateRate(final int sum, final int price) {
        double rate = ((double) sum) / ((double) price) * 100.0;
        return Math.round(rate * 100) / 100.0;
    }
}
