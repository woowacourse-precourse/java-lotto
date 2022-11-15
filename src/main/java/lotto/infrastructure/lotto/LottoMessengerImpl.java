package lotto.infrastructure.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoMessenger;
import lotto.domain.profit.Profit;
import lotto.domain.statistics.Rank;
import lotto.domain.statistics.Statistics;
import lotto.global.message.TextMessage;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMessengerImpl implements LottoMessenger {

    @Override
    public String requestMoney() {
        System.out.println(TextMessage.REQUEST_MONEY);
        return Console.readLine();
    }

    @Override
    public void sendLottosInfo(Lottos lottos) {
        System.out.println(TextMessage.sendLottosCount(lottos.size()));
        lottos.sendInfo();
    }

    @Override
    public String requestWinningNumbers() {
        System.out.println(TextMessage.REQUEST_WINNING_NUMBERS);
        return Console.readLine();
    }

    @Override
    public String requestBonusNumber() {
        System.out.println(TextMessage.REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }

    @Override
    public void sendStatistics(Statistics statistics) {
        final Map<Rank, Integer> result = statistics.getResult();
        final List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toUnmodifiableList());

        System.out.println(TextMessage.SEND_STATISTICS);
        ranks.forEach(rank -> printStatics(rank, result.get(rank)));
    }

    @Override
    public void sendProfit(Profit profit) {
        System.out.println(TextMessage.sendProfit(profit.getRate()));
    }

    private void printStatics(Rank rank, Integer count) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###");

        if (rank.equals(Rank.SECOND)) {
            System.out.printf((TextMessage.STATISTICS_BONUS_FORMAT) + "%n", rank.getMatch(), decimalFormat.format(rank.getReward()), count);
            return;
        }
        if (rank.equals(Rank.NOTHING)) {
            return;
        }
        System.out.printf((TextMessage.STATISTICS_FORMAT) + "%n", rank.getMatch(), decimalFormat.format(rank.getReward()), count);
    }
}
