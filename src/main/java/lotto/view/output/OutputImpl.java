package lotto.view.output;

import lotto.model.Lotto;
import lotto.model.statistics.Rank;
import lotto.model.statistics.Statistics;
import lotto.utils.EventMessage;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputImpl implements Output{
    private final static DecimalFormat df = new DecimalFormat("###,###");
    private final static DecimalFormat dfd = new DecimalFormat("###,##0.0");
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
        System.out.println(EventMessage.NEW_LINE.message);
    }

    @Override
    public void printStatistics(Statistics statistics) {
        System.out.println(EventMessage.NEW_LINE.message);
        System.out.println(EventMessage.STATISTICS_HEADER.message);
        Map<Rank, BigDecimal> rankCount = statistics.getRankCount();
        for (Rank rank : rankCount.keySet()) {
            if(rank.equals(Rank.SECOND)){
                System.out.println(String.format(EventMessage.STATISTICS_BODY_SECOND.message,rank.getSameCount(),df.format(rank.getPrize()),rankCount.get(rank).toString()));
                continue;
            }
            System.out.println(String.format(EventMessage.STATISTICS_BODY.message,rank.getSameCount(),df.format(rank.getPrize()),rankCount.get(rank).toString()));
        }
        System.out.print(String.format(EventMessage.STATISTICS_FOOTER.message,dfd.format(statistics.getYield())));
    }

    @Override
    public void printPurchaseMessage(BigDecimal count){
        System.out.println(EventMessage.NEW_LINE.message);
        System.out.println(String.format(EventMessage.ISSUED_AMOUNT.message,df.format(count)));
    }
}
