package lotto.view.output;

import lotto.model.Lotto;
import lotto.model.statistics.Rank;
import lotto.model.statistics.Statistics;
import lotto.utils.EventMessage;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputImpl implements Output{
    @Override
    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    @Override
    public void printEventMessage(EventMessage eventMessage) {
        System.out.println(eventMessage.message);
    }

    @Override
    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.print(EventMessage.NEW_LINE.message);
    }

    @Override
    public void printStatistics(Statistics statistics) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println(EventMessage.STATISTICS_HEADER.message);
        Map<Rank, BigDecimal> rankCount = statistics.getRankCount();
        for (Rank rank : rankCount.keySet()) {
            if(!rank.equals(Rank.FAIL)){
                System.out.println(String.format(EventMessage.STATISTICS_BODY.message,rank.getSameCount(),df.format(rank.getPrize()),rankCount.get(rank).toString()));
            }
        }
        System.out.print(String.format(EventMessage.STATISTICS_FOOTER.message,df.format(statistics.getYield().toString())));
    }
}
